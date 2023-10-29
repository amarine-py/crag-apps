package partner_finder.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import partner_finder.data.ClimberProfileRepository;
import partner_finder.models.ClimberProfile;

import java.util.List;
import java.util.Set;

@Service
public class ClimberProfileService {


    private final ClimberProfileRepository repository;
    public ClimberProfileService(ClimberProfileRepository repository) { this.repository = repository; }

    // READ methods
    public List<ClimberProfile> findAll() {
        List<ClimberProfile> initial = repository.findAll();
        if (initial.isEmpty()) {
            return null;
        }
        List<ClimberProfile> enabledProfiles = initial.stream().filter(ClimberProfile::isEnabled).toList();

        for (ClimberProfile profile : enabledProfiles) {
            profile.setEnums();
        }
        return enabledProfiles;
    }

    public ClimberProfile findById(int profileId) {
        ClimberProfile profile = repository.findById(profileId);
        if (profile == null) {
            return null;
        }
        profile.setEnums();
        return profile;
    }

    public ClimberProfile findByUsername(String username) {
        ClimberProfile profile = repository.findByUsername(username);
        if (profile == null) {
            return null;
        }
        profile.setEnums();
        return profile;
    }

    public ClimberProfile findByClimberId(int climberId) {
        ClimberProfile profile = repository.findByClimberId(climberId);
        if (profile == null) {
            return null;
        }
        profile.setEnums();
        return profile;
    }

    // CREATE methods
    public Result<ClimberProfile> create(ClimberProfile climberProfile) {
        Result<ClimberProfile> result = new Result<>();
        if (findByClimberId(climberProfile.getClimberId()) != null) {
            result.addMessage("This climber already has a profile!", ResultType.INVALID);
            return result;
        }

        result = validate(climberProfile);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(climberProfile));
        return result;
    }

    // UPDATE methods
    public Result<ClimberProfile> update(ClimberProfile climberProfile) {
        Result<ClimberProfile> result = validate(climberProfile);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(repository.save(climberProfile));
        return result;
    }

    public boolean enableById(int profileId) {
        ClimberProfile oldClimberProfile = repository.findById(profileId);
        if (oldClimberProfile == null) {
            return false;
        }
        if (oldClimberProfile.isEnabled()) {
           return false;
        }
        oldClimberProfile.setEnabled(true);
        ClimberProfile newClimberProfile = repository.save(oldClimberProfile);
        return newClimberProfile.isEnabled();

    }

    // DELETE methods
    public boolean disableById(int profileId) {
        ClimberProfile oldClimberProfile = repository.findById(profileId);
        if (oldClimberProfile == null) {
            return false;
        }
        if (oldClimberProfile.isEnabled()) {
            oldClimberProfile.setEnabled(false);
            ClimberProfile newClimberProfile = repository.save(oldClimberProfile);
            return !newClimberProfile.isEnabled();
        }
        return false;

    }

    public boolean deleteById(int profileId) {
        repository.deleteById(profileId);
        return repository.findById(profileId) == null;
    }


    // HELPER methods
    public Result<ClimberProfile> inputValidation(ClimberProfile profile) {
        Result<ClimberProfile> result = new Result<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ClimberProfile>> violations = validator.validate(profile);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<ClimberProfile> violation : violations) {
                result.addMessage(violation.getMessage(), ResultType.INVALID);
            }
        }
        return result;
    }

    public Result<ClimberProfile> usernameValidation(ClimberProfile profile) {
        Result<ClimberProfile> result = new Result<>();

        if (repository.findByUsername(profile.getUsername()) != null) {
            result.addMessage("Username already exists.", ResultType.INVALID);

        }

        return result;
    }

    public Result<ClimberProfile> validate(ClimberProfile profile) {
        Result<ClimberProfile> result = inputValidation(profile);
        if (!result.isSuccess()) {
            return result;
        }

        if (profile.getProfileId() < 1) {
            result = usernameValidation(profile);
            if (!result.isSuccess()) {
                return result;
            }
        }


        result.setPayload(repository.save(profile));
        return result;
    }
}
