package partner_finder.data;

import partner_finder.models.Climber;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClimberRepository {

    Climber findById(int climberId);
    List<Climber> findAll();

    Climber create(Climber climber);
    Climber update(Climber climber);

    @Transactional
    boolean deleteById(int climberId);
}
