package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.*;

import java.util.List;

public interface ClimberProfileRepository extends JpaRepository<ClimberProfile, Integer> {

    ClimberProfile findById(int profileId);

    ClimberProfile findByUsername(String username);
    List<ClimberProfile> findAll();
//
    ClimberProfile save(ClimberProfile climberProfile);
//
//    // Must set the ClimberProfile from the Climber to null
//    // before you can delete the Climber Profile

    @Transactional
    void deleteById(int profileId);


}
