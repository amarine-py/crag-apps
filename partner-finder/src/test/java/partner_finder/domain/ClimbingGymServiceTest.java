package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.ClimbingGymRepository;
import partner_finder.data.ClimbingGymRepository;
import partner_finder.models.ClimbingGym;
import partner_finder.models.ClimbingGym;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static partner_finder.TestHelper.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimbingGymServiceTest {

    @MockBean
    ClimbingGymRepository repository;

    @Autowired
    ClimbingGymService service;

    // READ

    @Test
    void shouldFindClimbingGymById() {
        ClimbingGym climbingGym = makeGym(1);
        when(repository.findById(1)).thenReturn(Optional.of(climbingGym));
        ClimbingGym actual = service.findById(1);

        assertEquals("Gym #1", actual.getName());
    }

    // CREATE

    @Test
    void shouldCreateNewClimbingGym() {
        ClimbingGym newClimbingGym = makeGym(0);
        ClimbingGym expected = makeGym(1);
        when(repository.save(newClimbingGym)).thenReturn(expected);
        Result<ClimbingGym> result = service.create(newClimbingGym);

        assertEquals("Gym #1", expected.getName());

    }

    @Test
    void shouldNotCreateInvalidClimbingGym() {
        ClimbingGym climbingGym = new ClimbingGym();
        Result<ClimbingGym> result = service.create(climbingGym);
        System.out.println(result);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());
    }

    // UPDATE

    @Test
    void shouldUpdateSubject() {
        ClimbingGym newClimbingGym = makeGym(1);
        when(repository.save(newClimbingGym)).thenReturn(newClimbingGym);
        Result<ClimbingGym> result = service.update(newClimbingGym);
        System.out.println(result);
        assertTrue(result.isSuccess());
        newClimbingGym.setName("New Name");
        result = service.update(newClimbingGym);
        assertEquals("New Name", newClimbingGym.getName());

    }

    @Test
    void shouldNotUpdateWith3Messages() {
        ClimbingGym climbingGym = new ClimbingGym();
        Result<ClimbingGym> result = service.update(climbingGym);
        System.out.println(result);
        assertEquals(1, result.getMessages().size());
    }

    // DELETE

    @Test
    void shouldDelete() {

        assertTrue(service.deleteById(1));
    }

}