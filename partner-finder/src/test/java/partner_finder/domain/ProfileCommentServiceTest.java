package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.ProfileCommentRepository;
import partner_finder.models.Badge;
import partner_finder.models.ProfileComment;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static partner_finder.TestHelper.makeBadge;
import static partner_finder.TestHelper.makeComment;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProfileCommentServiceTest {

    @MockBean
    ProfileCommentRepository repository;

    @Autowired
    ProfileCommentService service;

    // READ

    @Test
    void shouldFindProfileCommentById() {
        ProfileComment comment = makeComment(1);
        when(repository.findById(1)).thenReturn(Optional.of(comment));
        ProfileComment actual = service.findById(1);

        assertEquals("Comment #1 subject", actual.getSubject());
    }

    @Test
    void shouldFindProfileCommentsByReceivingClimberId() {
        ProfileComment comment1 = makeComment(1);
        ProfileComment comment2 = makeComment(2);
        when(repository.findByReceivingClimberId(2)).thenReturn(List.of(comment1, comment2));
        List<ProfileComment> comments = service.findByReceivingClimberId(2);
        assertEquals(2, comments.size());
    }

    @Test
    void shouldFindProfileCommentsByPostingClimberId() {
        ProfileComment comment1 = makeComment(1);
        when(repository.findByPostingClimberId(2)).thenReturn(List.of(comment1));
        List<ProfileComment> comments = service.findByPostingClimberId(2);
        assertEquals(1, comments.size());
    }

    // CREATE

    @Test
    void shouldCreateNewComment() {
        ProfileComment newComment = makeComment(0);
        ProfileComment expected = makeComment(1);
        when(repository.save(newComment)).thenReturn(expected);
        Result<ProfileComment> result = service.create(newComment);

        assertEquals("Comment #1 text", expected.getText());

    }

    @Test
    void shouldNotCreateInvalidComment() {
        ProfileComment comment = new ProfileComment();
        comment.setSubject("New Subject.");
        Result<ProfileComment> result = service.create(comment);
        System.out.println(result);
        assertFalse(result.isSuccess());
    }

    // UPDATE

    @Test
    void shouldUpdateSubject() {
        ProfileComment newComment = makeComment(1);
        when(repository.save(newComment)).thenReturn(newComment);
        Result<ProfileComment> result = service.update(newComment);
        System.out.println(result);
        assertTrue(result.isSuccess());
        newComment.setSubject("New Subject!!!");
        result = service.update(newComment);
        assertEquals("New Subject!!!", newComment.getSubject());

    }

    @Test
    void shouldNotUpdateWith3Messages() {
        ProfileComment comment = new ProfileComment();
        Result<ProfileComment> result = service.update(comment);
        System.out.println(result);
        assertEquals(4, result.getMessages().size());
    }

// DELETE

    @Test
    void shouldDelete() {
        assertTrue(service.deleteById(1));
    }

    @Test
    void shouldNotDeleteNullId() {
        assertTrue(service.deleteById(99));
    }
}