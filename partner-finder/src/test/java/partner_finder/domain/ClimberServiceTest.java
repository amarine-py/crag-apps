package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.ClimberRepository;
import partner_finder.models.Climber;


import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static partner_finder.TestHelper.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimberServiceTest {

    @MockBean
    ClimberRepository repository;

    @Autowired
    ClimberService service;

    // READ

    @Test
    void shouldFindClimberById() {
        Climber climber = makeClimber(1);
        when(repository.findById(1)).thenReturn(climber);
        Climber actual = service.findById(1);

        assertEquals("Climber #1", actual.getUsername());
    }

    // CREATE

    @Test
    void shouldCreateNewClimber() {
        Climber newClimber = makeClimber(0);
        Climber expected = makeClimber(1);
        when(repository.create(newClimber)).thenReturn(expected);
        Result<Climber> result = service.create(newClimber);

        assertEquals("Climber #1", expected.getUsername());

    }

    @Test
    void shouldNotCreateInvalidClimber() {
        Climber climber = new Climber();
        climber.setUsername("New Subject.");
        Result<Climber> result = service.create(climber);
        System.out.println(result);
        assertFalse(result.isSuccess());
        assertEquals(4, result.getMessages().size());
    }

    @Test
    void shouldNotCreateDobInFuture() {
        Climber newClimber = makeClimber(1);
        newClimber.setDob(LocalDate.now().plusYears(5));
        Result<Climber> result = service.create(newClimber);
        System.out.println(result);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());

    }

    // UPDATE

    @Test
    void shouldUpdateSubject() {
        Climber newClimber = makeClimber(1);
        when(repository.update(newClimber)).thenReturn(newClimber);
        Result<Climber> result = service.update(newClimber);
        System.out.println(result);
        assertTrue(result.isSuccess());
        newClimber.setUsername("New Username");
        result = service.update(newClimber);
        assertEquals("New Username", newClimber.getUsername());

    }

    @Test
    void shouldNotUpdateWith3Messages() {
        Climber climber = new Climber();
        Result<Climber> result = service.update(climber);
        System.out.println(result);
        assertEquals(5, result.getMessages().size());
    }

// DELETE

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