package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ClimbingGymRepository;
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

    // DELETE methods
    public boolean disableById(int climbingGymId) {
        ClimbingGym oldClimbingGym = repository.findById(climbingGymId).orElse(null);
        oldClimbingGym.setEnabled(false);
        ClimbingGym newClimbingGym = repository.save(oldClimbingGym);
        return newClimbingGym != null;
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
