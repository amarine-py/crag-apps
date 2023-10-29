package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.ProfileCommentService;
import partner_finder.domain.Result;
import partner_finder.models.ProfileComment;

import java.util.List;

@RestController
@RequestMapping("/api/profile-comment")
public class ProfileCommentController {

    private final ProfileCommentService service;
    public ProfileCommentController(ProfileCommentService service) { this.service = service; }

    // READ

    @GetMapping
    public List<ProfileComment> findAll() { return service.findAll(); }

    @GetMapping("/id={id}")
    public ProfileComment findById(@PathVariable int id) { return service.findById(id); }

    // This will find all profile comments by the climberId of the climberProfile they are assigned to
    @GetMapping("/receiver={id}")
    public List<ProfileComment> findByReceivingClimberId(@PathVariable int id) { return service.findByReceivingClimberId(id); }

    // This will find all profileComments by the climberId of the poster
    @GetMapping("/poster={id}")
    public List<ProfileComment> findByPostingClimberId(@PathVariable int id) { return service.findByPostingClimberId(id); }


    // CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProfileComment profileComment) {

        Result<ProfileComment> result = service.create(profileComment);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody ProfileComment profileComment) {
        if (id != profileComment.getProfileCommentId()) {
            return new ResponseEntity<>("Path ID does not match profileComment ID.", HttpStatus.CONFLICT);
        }

        Result<ProfileComment> result = service.update(profileComment);
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
        return new ResponseEntity<>("Unable to disable comment.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Object> enable(@PathVariable int id) {
        if (service.enableById(id)) {
            return new ResponseEntity<>("Success!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Unable to enable comment.", HttpStatus.BAD_REQUEST);
    }
}
