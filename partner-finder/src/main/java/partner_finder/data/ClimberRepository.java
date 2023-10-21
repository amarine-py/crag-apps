package partner_finder.data;

import partner_finder.models.Climber;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClimberRepository {

    Climber findById(int climberId);

    Climber findByEmail(String email);

    List<Climber> findByPartialEmail(String email);

    List<Climber> findAll();

    Climber create(Climber climber);
    Climber update(Climber climber);

    boolean enableById(int climberId);

    boolean disableById(int climberId);

    @Transactional
    boolean deleteById(int climberId);
}
