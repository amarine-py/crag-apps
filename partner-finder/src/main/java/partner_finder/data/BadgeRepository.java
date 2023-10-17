package partner_finder.data;

import partner_finder.models.Badge;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BadgeRepository {

    Badge findById(int badgeId);
    Badge findByName(int badgeName);
    List<Badge> findall();

    Badge create(Badge badge);
    Badge update(Badge badge);

    @Transactional
    boolean deleteById(int badgeId);

}
