package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.ClimberProfileService;
import partner_finder.domain.Result;
import partner_finder.models.Climber;
import partner_finder.models.ClimberProfile;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ClimberProfileController {

    private final ClimberProfileService service;
    public ClimberProfileController(ClimberProfileService service) { this.service = service; }

    // READ

    @GetMapping
    public List<ClimberProfile> findAll() { return service.findAll(); }

    @GetMapping("/username={username}")
    public ClimberProfile findByUsername(@PathVariable String username) { return service.findByUsername(username); }

    @GetMapping("/id={id}")
    public ClimberProfile findById(@PathVariable int id) { return service.findById(id); }

    // CREATE
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ClimberProfile profile) {

        Result<ClimberProfile> result = service.create(profile);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody ClimberProfile profile) {
        if (id != profile.getProfileId()) {
            return new ResponseEntity<>("Path ID does not match profile ID.", HttpStatus.CONFLICT);
        }

        Result<ClimberProfile> result = service.update(profile);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }


    // DELETE or disable/enable
    @PutMapping("/{id}/disable")
    public ResponseEntity<Object> disable(@PathVariable int id) {
        if (service.disableById(id)) {
            return new ResponseEntity<>("Success!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Unable to disable profile.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Object> enable(@PathVariable int id) {
        if (service.enableById(id)) {
            return new ResponseEntity<>("Success!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Unable to enable profile.", HttpStatus.BAD_REQUEST);
    }


}
