package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.Climber;
import partner_finder.models.ClimberProfile;
import partner_finder.models.Location;
import partner_finder.models.Sex;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimberJdbcTemplateRepositoryTest {

    @Autowired
    ClimberJdbcTemplateRepository repository;

    @Autowired
    LocationJdbcTemplateRepository locationRepository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests

    @Test
    void shouldFindById() {
        Climber actual = repository.findById(1);
        System.out.println(actual);
        System.out.println(actual.getClimberSex().name());
        assertEquals("Air Alexy", actual.getUsername());
    }

    @Test
    void shouldFindAll() {
        List<Climber> actual = repository.findAll();
        assertEquals(4, actual.size());
    }


    // CREATE tests

    @Test
    @Transactional
    void shouldCreateClimber() {
        List<Climber> climbers = repository.findAll();
        assertEquals(4, climbers.size());

        Climber climber = new Climber();
        climber.setAppUserId(1);
        climber.setUsername("New Username");
        climber.setFirstName("New");
        climber.setLastName("Lastname");
        climber.setDob(LocalDate.now().minusYears(20));
        climber.setClimberSex(Sex.FEMALE);

        Climber actual = repository.create(climber);

        climbers = repository.findAll();

        assertEquals(5, climbers.size());

    }


    // UPDATE tests

    @Test
    @Transactional
    void shouldUpdateClimber() {
        Climber actual = repository.findById(1);

        assertEquals("Air Alexy", actual.getUsername());

        actual.setUsername("New Username");
        actual.setClimberSex(Sex.OTHER);

        repository.update(actual);
        Climber updatedClimber = repository.findById(1);

        assertEquals("New Username", updatedClimber.getUsername());
        assertEquals("OTHER", updatedClimber.getClimberSex().name());
    }


    // DELETE tests

    @Test
    void shouldDisableClimberById() {
        assertTrue(repository.disableById(1));
        Climber climber = repository.findById(1);
        assertFalse(climber.isEnabled());
    }
    @Test
    void shouldDeleteClimberById() {
        assertTrue(repository.deleteById(4));
        assertNull(repository.findById(4));
    }
}