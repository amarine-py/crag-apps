package partner_finder.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.AppUserService;
import partner_finder.domain.Result;
import partner_finder.models.AppUser;
import partner_finder.security.JwtConverter;

import java.util.HashMap;
import java.util.Map;

@RestController
@ConditionalOnWebApplication
public class AuthController {

    private final AppUserService appUserService;
    private final JwtConverter jwtConverter;
    private final AuthenticationManager authenticationManager;

    public AuthController(AppUserService appUserService,
                          JwtConverter jwtConverter,
                          AuthenticationManager authenticationManager) {
        this.appUserService = appUserService;
        this.jwtConverter = jwtConverter;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                credentials.get("username"), credentials.get("password"));

        // AuthenticationException handling is located in the GlobalErrHandler
        Authentication authentication = authenticationManager.authenticate(authToken);
        if (authentication.isAuthenticated()) {
            AppUser appUser = (AppUser) authentication.getPrincipal();
            String jwt = jwtConverter.getTokenFromUser(appUser);
            Map<String, String> result = new HashMap<>();
            result.put("jwt_token", jwt);
            return ResponseEntity.ok(result);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> credentials) {
        Result<AppUser> result = appUserService.add(
                credentials.get("username"), credentials.get("password"));
        if (result.isSuccess()) {
            Map<String, Integer> userId = new HashMap<>();
            userId.put("user_id", result.getPayload().getAppUserId());
            return new ResponseEntity<>(userId, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/api/refresh-token")
    public ResponseEntity<Map<String, String>> refreshToken(@AuthenticationPrincipal AppUser appUser) {
        String jwt = jwtConverter.getTokenFromUser(appUser);
        Map<String, String> result = new HashMap<>();
        result.put("jwt_token", jwt);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/user/{username}")
    public AppUser findByUsername(@PathVariable String username) { return appUserService.loadUserByUsername(username); }

    @PutMapping("/api/user/{username}/disable")
    public boolean disableByUsername(@PathVariable String username) { return appUserService.disableByUsername(username); }


}
