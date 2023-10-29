package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ClimberBadgeRepository;
import partner_finder.models.ClimberBadge;

import java.util.List;
import java.util.Set;

@Service
public class ClimberBadgeService {

    private final ClimberBadgeRepository repository;
    public ClimberBadgeService(ClimberBadgeRepository repository) { this.repository = repository; }

    // READ
    public List<ClimberBadge> findAll() { return repository.findAll(); }

    public ClimberBadge findByClimberBadgeId(int climberBadgeId) { return repository.findByClimberBadgeId(climberBadgeId); }

    public List<ClimberBadge> findByBadgeId(int badgeId) { return repository.findByBadgeId(badgeId); }

    public List<ClimberBadge> findByAwardeeId(int awardeeId) { return repository.findByAwardeeId(awardeeId); }

    public List<ClimberBadge> findByGiverId(int giverId) { return repository.findByGiverId(giverId); }

    // CREATE methods
    public Result<ClimberBadge> create(ClimberBadge climberBadge) {
        Result<ClimberBadge> result = inputValidation(climberBadge);
        if (climberBadge.getClimberBadgeId() > 0) {
            result.addMessage("New climber badge cannot have ID.", ResultType.INVALID);
            return result;
        }
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(climberBadge));
        return result;
    }

    // UPDATE methods
    public Result<ClimberBadge> update(ClimberBadge climberBadge) {
        Result<ClimberBadge> result = inputValidation(climberBadge);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(climberBadge));
        return result;
    }

    public boolean enableById(int climberBadgeId) {
        ClimberBadge old = repository.findById(climberBadgeId).orElse(null);
        if (old == null) {
            return false;
        }
        if (old.isEnabled()) {
            return false;
        }
        old.setEnabled(true);
        ClimberBadge newClimberBadge = repository.save(old);
        return newClimberBadge.isEnabled();

    }

    // DELETE methods
    public boolean disableById(int climberBadgeId) {
        ClimberBadge old = repository.findById(climberBadgeId).orElse(null);
        if (old == null) {
            return false;
        }
        if (old.isEnabled()) {
            old.setEnabled(false);
            ClimberBadge newClimberBadge = repository.save(old);
            return !newClimberBadge.isEnabled();
        }
        return false;
    }

    public boolean deleteById(int climberBadgeId) {
        repository.deleteById(climberBadgeId);
        return repository.findById(climberBadgeId).isEmpty();
    }

    // HELPER methods
    public Result<ClimberBadge> inputValidation(ClimberBadge climberBadge) {
        Result<ClimberBadge> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ClimberBadge>> violations = validator.validate(climberBadge);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<ClimberBadge> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }

}
