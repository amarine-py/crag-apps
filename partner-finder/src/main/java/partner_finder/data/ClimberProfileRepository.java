package partner_finder.data;

import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.*;

import java.util.List;

public interface ClimberProfileRepository {

    ClimberProfile findbyId(int profileId);
    List<ClimberProfile> findBySafetyAttitude(SafetyAttitude safetyAttitude);
    List<ClimberProfile> findByClimbingMotivation(ClimbingMotivation climbingMotivation);
    List<ClimberProfile> findByClimbingStyle(ClimbingStyle climbingStyle);
    List<ClimberProfile> findByCountry(Country country);
    List<ClimberProfile> findByState(StateProvince state);
    List<ClimberProfile> findByPostalCode(String postalCode);
    List<ClimberProfile> findByLocationCode(int locationCode);
    List<ClimberProfile> findAll();

    ClimberProfile create(ClimberProfile climberProfile);
    ClimberProfile update(ClimberProfile climberProfile);

    // Must set the ClimberProfile from the Climber to null
    // before you can delete the Climber Profile
    @Transactional
    boolean deleteById(int profileId);

}
