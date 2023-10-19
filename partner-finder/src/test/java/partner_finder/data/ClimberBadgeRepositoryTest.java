package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.ClimberBadge;
import partner_finder.models.ClimbingGym;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimberBadgeRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ClimberBadgeRepository repository;
    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests
    @Test
    void shouldFindById() {
        ClimberBadge actual = repository.findById(1).orElse(null);
        assertEquals(1, actual.getAwardeeId());

    }

    @Test
    void shouldFindAll() {
        List<ClimberBadge> climberBadges = repository.findAll();
        assertEquals(3, climberBadges.size());
    }

    // CREATE tests

    @Test
    @Transactional
    void shouldCreateClimberBadge() {
        ClimberBadge arg = new ClimberBadge();
        arg.setAwardeeId(2);
        arg.setBadgeId(1);
        arg.setGiverId(1);
        arg.setDateAwarded(LocalDate.of(2020, 1, 1));

        ClimberBadge actual = repository.save(arg);
        assertEquals(4, actual.getClimberBadgeId());

        actual = repository.findById(4).orElse(null);
        assertEquals(1, actual.getGiverId());
    }

    // UPDATE tests

    @Test
    @Transactional
    void shouldUpdateClimberBadge() {
        ClimberBadge arg = repository.findById(1).orElse(null);
        arg.setAwardeeId(3);

        ClimberBadge actual = repository.save(arg);
        assertEquals(3, actual.getAwardeeId());

        actual = repository.findById(1).orElse(null);
        assertEquals(3, actual.getAwardeeId());

    }

    @Test
    @Transactional
    void shouldDeleteClimberBadge() {
        ClimberBadge arg = repository.findById(3).orElse(null);
        assertNotNull(arg);

        repository.deleteById(3);

        arg = repository.findById(3).orElse(null);
        assertNull(arg);
    }


}