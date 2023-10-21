package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.ClimberBadge;
import partner_finder.models.ClimbingGym;

import java.util.List;

public interface ClimberBadgeRepository extends JpaRepository<ClimberBadge, Integer> {

    ClimberBadge findByClimberBadgeId(int climberBadgeId);

    List<ClimberBadge> findByBadgeId(int badgeId);

    List<ClimberBadge> findByAwardeeId(int awardeeId);

    List<ClimberBadge> findByGiverId(int giverId);
}
