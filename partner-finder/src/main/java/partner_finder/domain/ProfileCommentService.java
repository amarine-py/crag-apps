package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ProfileCommentRepository;
import partner_finder.models.ProfileComment;
import java.util.List;
import java.util.Set;

@Service
public class ProfileCommentService {

    private final ProfileCommentRepository repository;
    public ProfileCommentService(ProfileCommentRepository repository) { this.repository = repository; }


    // READ methods
    public List<ProfileComment> findAll() { return repository.findAll(); }

    public ProfileComment findById(int commentId) { return repository.findById(commentId).orElse(null); }

    public List<ProfileComment> findByReceivingClimberId(int receivingClimberId) {
        return repository.findByReceivingClimberId(receivingClimberId);
    }

    public List<ProfileComment> findByPostingClimberId(int receivingClimberId) {
        return repository.findByPostingClimberId(receivingClimberId);
    }

    // CREATE methods
    public Result<ProfileComment> create(ProfileComment profileComment) {
        Result<ProfileComment> result = inputValidation(profileComment);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(profileComment));
        return result;
    }

    // UPDATE methods
    public Result<ProfileComment> update(ProfileComment profileComment) {
        Result<ProfileComment> result = inputValidation(profileComment);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(profileComment));
        return result;
    }

    public boolean enableById(int id) {
        ProfileComment old = repository.findById(id).orElse(null);
        if (old == null) {
            return false;
        }
        if (old.isEnabled()) {
            return false;
        }
        old.setEnabled(true);
        ProfileComment newComment = repository.save(old);
        return newComment.isEnabled();

    }

    // DELETE methods
    public boolean disableById(int id) {
        ProfileComment old = repository.findById(id).orElse(null);
        if (old == null) {
            return false;
        }
        if (old.isEnabled()) {
            old.setEnabled(false);
            ProfileComment newComment = repository.save(old);
            return !newComment.isEnabled();
        }
        return false;
    }

    public boolean deleteById(int profileCommentId) {
        repository.deleteById(profileCommentId);
        return repository.findById(profileCommentId).orElse(null) == null;
    }
    
    
    // HELPER methods
    public Result<ProfileComment> inputValidation(ProfileComment profileComment) {
        Result<ProfileComment> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ProfileComment>> violations = validator.validate(profileComment);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<ProfileComment> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }
    
}
