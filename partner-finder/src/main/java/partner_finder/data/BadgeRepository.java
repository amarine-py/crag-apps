package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.Badge;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {

    Badge findById(int badgeId);
    Badge findByName(String badgeName);
    List<Badge> findAll();

    // creates new Badge, if given Badge w/ no ID or new ID
    // updates existing Badge if given Badge w/ existing Id
    Badge save(Badge badge);

    // REMEMBER: deleteById() does not return anything
    @Transactional
    void deleteById(int badgeId);

}
