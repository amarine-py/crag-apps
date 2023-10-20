package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ClimberRepository;
import partner_finder.models.Climber;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClimberService {

    private final ClimberRepository repository;
    public ClimberService(ClimberRepository repository) { this.repository = repository; }


    // READ methods
    public List<Climber> findAll() { return repository.findAll(); }

    public Climber findById(int climberId) { return repository.findById(climberId); }


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
        Result<Climber> result = validate(climber);
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

    public Result<Climber> duplicateUsernameValidation(String newUsername) {
        Result<Climber> result = new Result<>();
        List<Climber> allClimbers = repository.findAll();
        ArrayList<String> usernames = allClimbers.stream().map(Climber::getUsername)
                .collect(Collectors.toCollection(ArrayList<String>::new));
        for (String username : usernames) {
            if (Objects.equals(newUsername, username)) {
                result.addMessage("Chosen username already exists.", ResultType.INVALID);
            }
        }
        return result;
    }

    public Result<Climber> validate(Climber climber) {
        Result<Climber> result = inputValidation(climber);
        if (!result.isSuccess()) {
            return result;
        }

        result = duplicateUsernameValidation(climber.getUsername());
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.create(climber));
        return result;
    }
}
