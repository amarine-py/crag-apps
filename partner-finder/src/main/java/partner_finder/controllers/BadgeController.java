package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.BadgeService;
import partner_finder.domain.Result;
import partner_finder.models.Badge;
import partner_finder.models.Climber;

import java.util.List;

@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    private final BadgeService service;
    public BadgeController(BadgeService service) { this.service = service; }

    // READ

    @GetMapping
    public List<Badge> findAll() { return service.findAll(); }

    @GetMapping("/id={id}")
    public Badge findById(@PathVariable int id) { return service.findById(id); }

    // CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Badge badge) {

        Result<Badge> result = service.create(badge);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Badge badge) {
        if (id != badge.getBadgeId()) {
            return new ResponseEntity<>("Path ID does not match badge ID.", HttpStatus.CONFLICT);
        }

        Result<Badge> result = service.update(badge);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    // DELETE or DISABLE
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
