package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.ClimberBadge;
import partner_finder.models.ClimbingGym;

public interface ClimberBadgeRepository extends JpaRepository<ClimberBadge, Integer> {

}
