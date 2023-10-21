package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.BadgeService;
import partner_finder.domain.ClimberBadgeService;
import partner_finder.domain.Result;
import partner_finder.models.Badge;
import partner_finder.models.ClimberBadge;

import java.util.List;

@RestController
@RequestMapping("/api/climber-badge")
public class ClimberBadgeController {

    private final ClimberBadgeService service;
    public ClimberBadgeController(ClimberBadgeService service) { this.service = service; }

    // READ

    @GetMapping
    public List<ClimberBadge> findAll() { return service.findAll(); }

    @GetMapping("/id={id}")
    public ClimberBadge findByClimberBadgeId(@PathVariable int id) { return service.findByClimberBadgeId(id); }

    @GetMapping("/awardee={awardeeId}")
    public List<ClimberBadge> findByAwardeeId(@PathVariable int awardeeId) { return service.findByAwardeeId(awardeeId); }

    @GetMapping("/giver={giverId}")
    public List<ClimberBadge> findByGiverId(@PathVariable int giverId) { return service.findByGiverId(giverId); }

    @GetMapping("/badge={badgeId}")
    public List<ClimberBadge> findByBadgeId(@PathVariable int badgeId) { return service.findByBadgeId(badgeId); }

// CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ClimberBadge climberBadge) {

        Result<ClimberBadge> result = service.create(climberBadge);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody ClimberBadge climberBadge) {
        if (id != climberBadge.getClimberBadgeId()) {
            return new ResponseEntity<>("Path ID does not match climber-badge ID.", HttpStatus.CONFLICT);
        }

        Result<ClimberBadge> result = service.update(climberBadge);
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
        return new ResponseEntity<>("Unable to disable climber-badge.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Object> enable(@PathVariable int id) {
        if (service.enableById(id)) {
            return new ResponseEntity<>("Success!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Unable to enable climber-badge.", HttpStatus.BAD_REQUEST);
    }

}
