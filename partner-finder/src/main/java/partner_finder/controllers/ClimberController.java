package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.ClimberService;
import partner_finder.domain.Result;
import partner_finder.models.Climber;

import java.util.List;

@RestController
@RequestMapping("/api/climber")
public class ClimberController {

    private final ClimberService service;
    public ClimberController(ClimberService service) { this.service = service; }

    // READ

    @GetMapping
    public List<Climber> findAll() { return service.findAll(); }

    @GetMapping("/email={email}")
    public List<Climber> findByEmail(@PathVariable String email) { return service.findByEmail(email); }

    @GetMapping("/id={id}")
    public Climber findById(@PathVariable int id) { return service.findById(id); }

    // CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Climber climber) {

        Result<Climber> result = service.create(climber);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Climber climber) {
        if (id != climber.getClimberId()) {
            return new ResponseEntity<>("Path ID does not match climber ID.", HttpStatus.CONFLICT);
        }

        Result<Climber> result = service.update(climber);
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
