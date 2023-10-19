package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.ClimbingGym;
import partner_finder.models.ProfileComment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimbingGymRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ClimbingGymRepository repository;
    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests
    @Test
    void shouldFindById() {
        ClimbingGym actual = repository.findById(1).orElse(null);
        assertEquals("Climbing Gym 1", actual.getName());
    }

    @Test
    void shouldFindAll() {
        List<ClimbingGym> gyms = repository.findAll();
        assertEquals(4, gyms.size());
    }

    // CREATE tests

    @Test
    @Transactional
    void shouldCreateClimbingGym() {
        ClimbingGym arg = new ClimbingGym();
        arg.setName("new gym");
        arg.setLocationId(1);

        ClimbingGym actual = repository.save(arg);
        assertEquals(5, actual.getGymId());

        actual = repository.findById(5).orElse(null);
        assertEquals("new gym", actual.getName());
    }

    // UPDATE tests

    @Test
    @Transactional
    void shouldUpdateClimbingGym() {
        ClimbingGym arg = repository.findById(1).orElse(null);
        arg.setName("changed name");

        ClimbingGym actual = repository.save(arg);
        assertEquals("changed name", actual.getName());

        actual = repository.findById(1).orElse(null);
        assertEquals("changed name", actual.getName());

    }

    // DELETE tests

    @Test
    @Transactional
    void shouldDeleteClimbingGym() {
        ClimbingGym arg = repository.findById(3).orElse(null);
        assertNotNull(arg);

        repository.deleteById(3);

        arg = repository.findById(3).orElse(null);
        assertNull(arg);
    }

}