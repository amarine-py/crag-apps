package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ClimbingGymRepository;
import partner_finder.models.Badge;
import partner_finder.models.ClimbingGym;
import java.util.List;
import java.util.Set;

@Service
public class ClimbingGymService {

    private final ClimbingGymRepository repository;
    public ClimbingGymService(ClimbingGymRepository repository) { this.repository = repository; }


    // READ methods
    public List<ClimbingGym> findAll() { return repository.findAll(); }

    public ClimbingGym findById(int climbingGymId) { return repository.findById(climbingGymId).orElse(null); }

    // CREATE methods
    public Result<ClimbingGym> create(ClimbingGym climbingGym) {
        Result<ClimbingGym> result = inputValidation(climbingGym);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(climbingGym));
        return result;
    }

    // UPDATE methods
    public Result<ClimbingGym> update(ClimbingGym climbingGym) {
        Result<ClimbingGym> result = inputValidation(climbingGym);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(climbingGym));
        return result;
    }

    public boolean enableById(int gymId) {
        ClimbingGym oldGym = repository.findById(gymId).orElse(null);
        if (oldGym == null) {
            return false;
        }
        if (oldGym.isEnabled()) {
            return false;
        }
        oldGym.setEnabled(true);
        ClimbingGym newGym = repository.save(oldGym);
        return newGym.isEnabled();

    }

    // DELETE methods
    public boolean disableById(int gymId) {
        ClimbingGym oldGym = repository.findById(gymId).orElse(null);
        if (oldGym == null) {
            return false;
        }
        if (oldGym.isEnabled()) {
            oldGym.setEnabled(false);
            ClimbingGym newGym = repository.save(oldGym);
            return !newGym.isEnabled();
        }
        return false;
    }

    public boolean deleteById(int climbingGymId) {
        repository.deleteById(climbingGymId);
        return repository.findById(climbingGymId).orElse(null) == null;
    }

    // HELPER methods
    public Result<ClimbingGym> inputValidation(ClimbingGym climbingGym) {
        Result<ClimbingGym> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ClimbingGym>> violations = validator.validate(climbingGym);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<ClimbingGym> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }
}
