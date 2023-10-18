package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.Badge;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BadgeRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BadgeRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests

    @Test
    void shouldFindById() {
        Badge badge = repository.findById(1);
        assertEquals("Expert Belayer", badge.getName());
    }

    @Test
    void shouldNotFindByNullId() {
        Badge badge = repository.findById(99);
        assertNull(badge);
    }

    @Test
    void shouldFindByName() {
        Badge badge = repository.findByName("Supportive Climber");
        assertEquals(2, badge.getBadgeId());
    }

    @Test
    void shouldFindAll4Badges() {
        List<Badge> badges = repository.findAll();
        assertEquals(4, badges.size());
    }


    // CREATE tests

    @Test
    @Transactional
    void shouldCreateBadge() {
        Badge arg = new Badge();
        arg.setBadgeId(5);
        arg.setName("New Badge");
        arg.setDescription("New badge description");
        arg.setCost(55);
        arg.setIconPath("icon.png");
        arg.setSupply(1000);

        Badge actual = repository.save(arg);
        assertEquals(5, actual.getBadgeId());

        actual = repository.findById(5);
        assertEquals("New Badge", actual.getName());
    }


    // UPDATE tests

    @Test
    @Transactional
    void shouldUpdateBadge() {
        Badge arg = new Badge();
        arg.setBadgeId(3);
        arg.setName("New Badge");
        arg.setDescription("New badge description");
        arg.setCost(55);
        arg.setIconPath("icon.png");
        arg.setSupply(1000);

        Badge actual = repository.save(arg);
        assertEquals("New Badge", actual.getName());

        actual = repository.findById(3);
        assertEquals(55, actual.getCost());

    }


    // DELETE tests

    @Test
    @Transactional
    void shouldDeleteBadge() {
        Badge arg = repository.findById(3);
        assertNotNull(arg);

        repository.deleteById(3);

        arg = repository.findById(3);
        assertNull(arg);
    }

}