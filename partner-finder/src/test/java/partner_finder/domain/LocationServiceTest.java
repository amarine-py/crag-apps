package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.LocationRepository;
import partner_finder.models.Location;
import partner_finder.models.Location;
import partner_finder.models.Location;
import partner_finder.models.StateProvince;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static partner_finder.TestHelper.makeLocation;
import static partner_finder.TestHelper.makeLocation;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LocationServiceTest {

    @MockBean
    LocationRepository repository;

    @Autowired
    LocationService service;

    // READ

    @Test
    void shouldFindLocationById() {
        Location location = makeLocation(1);
        when(repository.findById(1)).thenReturn(location);
        Location actual = service.findById(1);

        assertEquals(StateProvince.ARKANSAS, actual.getStateProvince());

    }

    // CREATE

    @Test
    void shouldCreateNewLocation() {
        Location newLocation = makeLocation(0);
        Location expected = makeLocation(1);
        when(repository.create(newLocation)).thenReturn(expected);
        Result<Location> result = service.create(newLocation);

        assertEquals("Little Rock", expected.getCity());

    }

    @Test
    void shouldNotCreateInvalidLocation() {
        Location location = new Location();
        location.setCity("New City");
        Result<Location> result = service.create(location);
        System.out.println(result);
        assertFalse(result.isSuccess());
        assertEquals(3, result.getMessages().size());
    }

    @Test
    void shouldNotCreatePostalCodeLongerThan12() {
        Location expected = makeLocation(1);
        expected.setPostalCode("123456789101112");
        Result<Location> result = service.create(expected);
        System.out.println(result);
        assertFalse(result.isSuccess());

    }

    // UPDATE

    @Test
    void shouldUpdateSubject() {
        Location newLocation = makeLocation(1);
        when(repository.update(newLocation)).thenReturn(newLocation);
        Result<Location> result = service.update(newLocation);
        System.out.println(result);
        assertTrue(result.isSuccess());
        newLocation.setCity("New City");
        result = service.update(newLocation);
        assertEquals("New City", newLocation.getCity());

    }

    @Test
    void shouldNotUpdateWith3Messages() {
        Location location = new Location();
        Result<Location> result = service.update(location);
        System.out.println(result);
        assertEquals(4, result.getMessages().size());
    }

    @Test
    void shouldDelete() {
        when(repository.deleteById(anyInt())).thenReturn(true);
        assertTrue(service.deleteById(1));
    }

    @Test
    void shouldNotDeleteNullId() {
        assertFalse(service.deleteById(99));
    }
    
}
