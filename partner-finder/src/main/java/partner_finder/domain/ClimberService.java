package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ClimberRepository;
import partner_finder.models.Climber;


import java.util.List;
import java.util.Set;

@Service
public class ClimberService {

    private final ClimberRepository repository;
    public ClimberService(ClimberRepository repository) { this.repository = repository; }


    // READ methods
    public List<Climber> findAll() { return repository.findAll(); }

    public Climber findById(int climberId) { return repository.findById(climberId); }

    public List<Climber> findByEmail(String email) { return repository.findByPartialEmail(email); }


    // CREATE methods
    public Result<Climber> create(Climber climber) {
        Result<Climber> result = validate(climber);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.create(climber));
        return result;
    }

    // UPDATE methods
    public Result<Climber> update(Climber climber) {
        Result<Climber> result = inputValidation(climber);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.update(climber));
        return result;
    }

    // DELETE methods
    public boolean disableById(int climberId) {
        return repository.disableById(climberId);
    }
    public boolean enableById(int climberId) { return repository.enableById(climberId); }

    public boolean deleteById(int climberId) {
        return repository.deleteById(climberId);
    }

    // HELPER methods
    public Result<Climber> inputValidation(Climber climber) {
        Result<Climber> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Climber>> violations = validator.validate(climber);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Climber> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }

    public Result<Climber> duplicateEmailValidation(String email) {
        Result<Climber> result = new Result<>();
        if (repository.findByEmail(email) != null) {
                result.addMessage("Email address already exists.", ResultType.INVALID);
            }

        return result;
    }

    public Result<Climber> validate(Climber climber) {
        Result<Climber> result = inputValidation(climber);
        if (!result.isSuccess()) {
            return result;
        }

        result = duplicateEmailValidation(climber.getEmail());
        if (!result.isSuccess()) {
            return result;
        }

        return result;
    }
}
