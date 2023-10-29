package partner_finder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner_finder.domain.LocationService;
import partner_finder.domain.Result;
import partner_finder.models.Location;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService service;
    public LocationController(LocationService service) { this.service = service; }

    // READ

    @GetMapping
    public List<Location> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Location findById(@PathVariable int id) { return service.findById(id); }


    // CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Location location) {

        Result<Location> result = service.create(location);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Location location) {
        if (id != location.getLocationId()) {
            return new ResponseEntity<>("Path ID does not match location ID.", HttpStatus.CONFLICT);
        }

        Result<Location> result = service.update(location);
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
        return new ResponseEntity<>("Unable to enable location.", HttpStatus.BAD_REQUEST);
    }
}
