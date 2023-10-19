package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.Forum;
import partner_finder.models.ProfileComment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProfileCommentRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProfileCommentRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests

    @Test
    void shouldFindById() {
        ProfileComment comment = repository.findById(1).orElse(null);
        assertEquals("great partner", comment.getSubject());
    }

    @Test
    void shouldFindAll() {
        List<ProfileComment> comments = repository.findAll();
        assertEquals(3, comments.size());
    }

    // CREATE tests

    @Test
    @Transactional
    void shouldCreateProfileComment() {
        ProfileComment arg = new ProfileComment();
        arg.setPostingClimberId(1);
        arg.setReceivingClimberId(2);
        arg.setSubject("new subject");
        arg.setText("comment text");
        arg.setPostedTimeString("2020-01-01 18:24:22");


        ProfileComment actual = repository.save(arg);
        assertEquals(4, actual.getProfileCommentId());

        actual = repository.findById(4).orElse(null);
        assertEquals("new subject", actual.getSubject());
    }

// UPDATE tests

    @Test
    @Transactional
    void shouldUpdateProfileComment() {
        ProfileComment arg = repository.findById(1).orElse(null);
        arg.setSubject("changed subject");

        ProfileComment actual = repository.save(arg);
        assertEquals("changed subject", actual.getSubject());

        actual = repository.findById(1).orElse(null);
        assertEquals("changed subject", actual.getSubject());

    }

    // DELETE tests

    @Test
    @Transactional
    void shouldDeleteProfileComment() {
        ProfileComment arg = repository.findById(3).orElse(null);
        assertNotNull(arg);

        repository.deleteById(3);

        arg = repository.findById(3).orElse(null);
        assertNull(arg);
    }

}