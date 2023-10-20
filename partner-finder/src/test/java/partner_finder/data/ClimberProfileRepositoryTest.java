package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.Badge;
import partner_finder.models.ClimberProfile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimberProfileRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ClimberProfileRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests

    @Test
    void shouldFindById() {
        ClimberProfile profile = repository.findById(1);
        profile.setEnums();
        System.out.println(profile);
        assertEquals("amarine@gmail.com", profile.getEmail());
    }

    @Test
    void shouldFindByEmail() {
        String email = "amarine@gmail.com";
        ClimberProfile profile = repository.findByEmail(email);
        profile.setEnums();
        System.out.println(profile);
        assertEquals(1, profile.getProfileId());
    }

    @Test
    void shouldFindAll() {
        List<ClimberProfile> profiles = repository.findAll();
        assertEquals(3, profiles.size());
    }


    // CREATE tests

    @Test
    @Transactional
    void shouldCreateProfile() {
        ClimberProfile arg = new ClimberProfile();
        arg.setClimberId(1);
        arg.setEmail("profile@example.com");
        arg.setDescription("profile description");
        arg.setLocationId(1);
        arg.setClimbingCountryName("UNITED_STATES");


        ClimberProfile actual = repository.save(arg);
        assertEquals(4, actual.getProfileId());

        actual = repository.findById(4);
        actual.setEnums();
        System.out.println(actual);
        assertEquals("profile@example.com", actual.getEmail());
    }

    @Test
    @Transactional
    void shouldUpdateProfile() {
        ClimberProfile arg = repository.findById(1);
        arg.setEmail("not the first email");

        ClimberProfile actual = repository.save(arg);
        assertEquals(1, actual.getProfileId());

        actual = repository.findById(1);
        System.out.println(actual);
        assertEquals("not the first email", actual.getEmail());
    }


    // DELETE tests

    @Test
    @Transactional
    void shouldDeleteProfile() {
        ClimberProfile arg = repository.findById(3);
        assertNotNull(arg);

        repository.deleteById(3);

        arg = repository.findById(3);
        assertNull(arg);
    }
}