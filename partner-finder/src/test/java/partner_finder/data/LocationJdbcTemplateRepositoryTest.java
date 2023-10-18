package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.Country;
import partner_finder.models.Location;
import partner_finder.models.StateProvince;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LocationJdbcTemplateRepositoryTest {

    @Autowired
    LocationJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests

    @Test
    void shouldFindById() {
        Location location = repository.findById(1);
        assertEquals("Mobile", location.getCity());
    }

    @Test
    void shouldNotFindByNullId() {
        Location location = repository.findById(99);
        assertNull(location);
    }

    @Test
    void shouldFindAll() {
        List<Location> locations = repository.findAll();
        assertEquals(4, locations.size());
    }


    // CREATE tests

    @Test
    void shouldCreateLocation() {
        Location expected = new Location();
        expected.setCountry(Country.CANADA);
        expected.setStateProvince(StateProvince.ALASKA);
        expected.setCity("Little Rock");
        expected.setPostalCode("55555");
        expected.setLocationCode(9);

        Location actual = repository.create(expected);
        expected.setLocationId(5);

        System.out.println(actual);
        assertEquals(expected, actual);
    }


    // UPDATE tests

    @Test
    @Transactional
    void shouldUpdateLocation() {
        Location location = repository.findById(1);
        location.setCity("Doofus Town");
        location = repository.update(location);
        Location actual = repository.findById(1);

        assertEquals(location.getCity(), actual.getCity());
    }

    @Test
    @Transactional
    void shouldNotUpdateLocationNullId() {
        Location location = repository.findById(1);
        location.setCity("Doofus Town");
        location.setLocationId(99);
        location = repository.update(location);

        assertNull(location);
    }

    @Test
    @Transactional
    void shouldDeleteLocation() {
        repository.deleteById(3);
        List<Location> locations = repository.findAll();
        assertEquals(3, locations.size());
    }
}