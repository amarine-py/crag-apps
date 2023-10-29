package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.ClimberProfileService;
import partner_finder.domain.Result;
import partner_finder.models.ClimberProfile;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/profile")
public class ClimberProfileController {

    private final ClimberProfileService service;
    public ClimberProfileController(ClimberProfileService service) { this.service = service; }

    // READ

    @GetMapping
    public List<ClimberProfile> findAll() {
        Stream<ClimberProfile> profileStream = service.findAll().stream();

        return profileStream.filter(
                ClimberProfile::isEnabled).toList();

    }

    // Find by username
    @GetMapping("/username={username}")
    public ClimberProfile findByUsername(@PathVariable String username) { return service.findByUsername(username); }

    @GetMapping("/id={id}")
    public ClimberProfile findById(@PathVariable int id) { return service.findById(id); }

    // Find by climberId
    @GetMapping("/climber-id={id}")
    public ClimberProfile findByClimberId(@PathVariable int id) {
        return service.findByClimberId(id);
    }

    // Find top-ten sorted by betaPoints
    @GetMapping("/top-10")
    public List<ClimberProfile> findTopTen() {
        List<ClimberProfile> allProfiles = service.findAll();
        return allProfiles.stream()
                .sorted(Comparator.comparingInt(ClimberProfile::getBetaPoints).reversed())
                .limit(10)
                .toList();
    }

    // Find all by climbingState
    @GetMapping("/state={stateName}")
    public List<ClimberProfile> findByStateName(@PathVariable String stateName) {
        String upperCaseState = stateName.toUpperCase();
        List<ClimberProfile> allProfiles = service.findAll();
        return allProfiles.stream()
                .filter((profile) -> Objects.equals(profile.getClimbingStateName(), upperCaseState))
                .sorted(Comparator.comparingInt(ClimberProfile::getBetaPoints).reversed())
                .limit(15)
                .toList();
    }

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
