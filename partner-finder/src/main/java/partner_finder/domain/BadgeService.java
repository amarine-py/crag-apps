package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.BadgeRepository;
import partner_finder.models.Badge;

import java.util.List;
import java.util.Set;

@Service
public class BadgeService {

    private final BadgeRepository repository;
    public BadgeService(BadgeRepository repository) { this.repository = repository; }


    // READ methods
    public List<Badge> findAll() { return repository.findAll(); }

    public Badge findById(int badgeId) { return repository.findById(badgeId); }

    // CREATE methods
    public Result<Badge> create(Badge badge) {
        Result<Badge> result = inputValidation(badge);
        if (badge.getBadgeId() > 0) {
            result.addMessage("New badge cannot have ID.", ResultType.INVALID);
            return result;
        }
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(badge));
        return result;
    }

    // UPDATE methods
    public Result<Badge> update(Badge badge) {
        Result<Badge> result = inputValidation(badge);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(badge));
        return result;
    }

    // DELETE methods
    public boolean disableById(int badgeId) {
        Badge oldBadge = repository.findById(badgeId);
        if (oldBadge == null) {
            return false;
        }
        oldBadge.setEnabled(false);
        Badge newBadge = repository.save(oldBadge);
        return newBadge != null;
    }

    public boolean deleteById(int badgeId) {
        repository.deleteById(badgeId);
        return repository.findById(badgeId) == null;
    }

    // HELPER methods
    public Result<Badge> inputValidation(Badge badge) {
        Result<Badge> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Badge>> violations = validator.validate(badge);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Badge> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }
    
    
}
