package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.*;

import java.util.List;

public interface ClimberProfileRepository extends JpaRepository<ClimberProfile, Integer> {

    ClimberProfile findById(int profileId);
//    List<ClimberProfile> findBySafetyAttitude(SafetyAttitude safetyAttitude);
//    List<ClimberProfile> findByClimbingMotivation(ClimbingMotivation climbingMotivation);
//    List<ClimberProfile> findByClimbingStyle(ClimbingStyle climbingStyle);
//    List<ClimberProfile> findByCountry(Country country);
//    List<ClimberProfile> findByState(StateProvince state);
//    List<ClimberProfile> findByPostalCode(String postalCode);
//    List<ClimberProfile> findByLocationCode(int locationCode);
    ClimberProfile findByEmail(String email);
    List<ClimberProfile> findAll();
//
    ClimberProfile save(ClimberProfile climberProfile);
//    ClimberProfile update(ClimberProfile climberProfile);
//
//    // Must set the ClimberProfile from the Climber to null
//    // before you can delete the Climber Profile


    @Transactional
    void deleteById(int profileId);

}
