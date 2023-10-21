package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.ClimberRepository;
import partner_finder.models.Climber;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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

        assertEquals("email1@example.com", actual.getEmail());
    }

    // CREATE

    @Test
    void shouldCreateNewClimber() {
        Climber newClimber = makeClimber(0);
        Climber expected = makeClimber(1);
        when(repository.create(newClimber)).thenReturn(expected);
        Result<Climber> result = service.create(newClimber);

        assertEquals("email1@example.com", expected.getEmail());

    }

    @Test
    void shouldNotCreateInvalidClimber() {
        Climber climber = new Climber();
        climber.setEmail("email@example.com");
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
    void shouldUpdateEmail() {
        Climber newClimber = makeClimber(1);
        when(repository.update(newClimber)).thenReturn(newClimber);
        Result<Climber> result = service.update(newClimber);
        System.out.println(result);
        assertTrue(result.isSuccess());
        newClimber.setEmail("newemail@example.com");
        result = service.update(newClimber);
        assertEquals("newemail@example.com", newClimber.getEmail());

    }

    @Test
    void shouldNotUpdateDuplicateEmail() {
        Climber existing = makeClimber(1);
        Climber updated = makeClimber(2);
        updated.setEmail(existing.getEmail());
        when(repository.findByPartialEmail(updated.getEmail())).thenReturn(List.of(existing));
        Result<Climber> result = service.update(updated);
        System.out.println(result);
        assertFalse(result.isSuccess());
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