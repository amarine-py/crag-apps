package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.models.Location;
import partner_finder.data.LocationRepository;

import java.util.List;
import java.util.Set;

@Service
public class LocationService {

    private final LocationRepository repository;
    public LocationService(LocationRepository repository) { this.repository = repository; }


    // READ methods
    public List<Location> findAll() { return repository.findAll(); }

    public Location findById(int locationId) { return repository.findById(locationId); }

    // CREATE methods
    public Result<Location> create(Location location) {
        Result<Location> result = inputValidation(location);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.create(location));
        return result;
    }

    // UPDATE methods
    public Result<Location> update(Location location) {
        Result<Location> result = inputValidation(location);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.update(location));
        return result;
    }

    // DELETE methods
    public boolean disableById(int locationId) {
        return repository.disableById(locationId);
    }

    public boolean deleteById(int locationId) {
        return repository.deleteById(locationId);
    }


    // HELPER methods
    public Result<Location> inputValidation(Location location) {
        Result<Location> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Location>> violations = validator.validate(location);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Location> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }
}
