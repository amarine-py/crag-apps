package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.BadgeRepository;
import partner_finder.models.Badge;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static partner_finder.TestHelper.makeBadge;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BadgeServiceTest {

    @MockBean
    BadgeRepository repository;

    @Autowired
    BadgeService service;

    // READ

    @Test
    void shouldFindBadgeById() {
        Badge badge = makeBadge(1);
        when(repository.findById(1)).thenReturn(badge);
        Badge actual = service.findById(1);

        assertEquals("Badge #1 name", actual.getName());
    }

    // CREATE

    @Test
    void shouldCreateNewBadge() {
        Badge newBadge = makeBadge(0);
        Badge expected = makeBadge(1);
        when(repository.save(newBadge)).thenReturn(expected);
        Result<Badge> result = service.create(newBadge);

        assertEquals("Badge #1 name", expected.getName());

    }

    @Test
    void shouldNotCreateInvalidBadge() {
        Badge badge = new Badge();
        badge.setName("New BAdge.");
        Result<Badge> result = service.create(badge);
        System.out.println(result);
        assertFalse(result.isSuccess());
    }

    // UPDATE

    @Test
    void shouldUpdateName() {
        Badge newBadge = makeBadge(1);
        when(repository.save(newBadge)).thenReturn(newBadge);
        Result<Badge> result = service.update(newBadge);
        System.out.println(result);
        assertTrue(result.isSuccess());
        newBadge.setName("New Name!!!");
        result = service.update(newBadge);
        assertEquals("New Name!!!", newBadge.getName());

    }

    @Test
    void shouldNotUpdateWith3Messages() {
        Badge badge = new Badge();
        Result<Badge> result = service.update(badge);
        assertEquals(3, result.getMessages().size());
    }

    // DELETE

    @Test
    void shouldDelete() {
        assertTrue(service.deleteById(1));
    }


}
