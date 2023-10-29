package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.ClimbingGymService;
import partner_finder.domain.Result;
import partner_finder.models.ClimbingGym;

import java.util.List;

@RestController
@RequestMapping("/api/climbing-gym")
public class ClimbingGymController {

    private final ClimbingGymService service;
    public ClimbingGymController(ClimbingGymService service) { this.service = service; }

    // READ

    @GetMapping
    public List<ClimbingGym> findAll() { return service.findAll(); }

    @GetMapping("/id={id}")
    public ClimbingGym findById(@PathVariable int id) { return service.findById(id); }

    // CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ClimbingGym climbingGym) {

        Result<ClimbingGym> result = service.create(climbingGym);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody ClimbingGym climbingGym) {
        if (id != climbingGym.getGymId()) {
            return new ResponseEntity<>("Path ID does not match climbingGym ID.", HttpStatus.CONFLICT);
        }

        Result<ClimbingGym> result = service.update(climbingGym);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    // ENABLE or DISABLE
    @PutMapping("/{id}/disable")
    public ResponseEntity<Object> disable(@PathVariable int id) {
        if (service.disableById(id)) {
            return new ResponseEntity<>("Success!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Unable to disable climber.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Object> enable(@PathVariable int id) {
        if (service.enableById(id)) {
            return new ResponseEntity<>("Success!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Unable to enable climber.", HttpStatus.BAD_REQUEST);
    }

}
