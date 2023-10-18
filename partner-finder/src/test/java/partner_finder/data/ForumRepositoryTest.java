package partner_finder.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import partner_finder.models.Badge;
import partner_finder.models.Forum;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ForumRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ForumRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }


    // READ tests

    @Test
    void shouldFindById() {
        Forum forum = repository.findById(1);
        assertEquals("Parent Forum", forum.getName());
    }

    @Test
    @Transactional
    void shouldFindChildrenById() {
        Forum forum = repository.findById(3);
        List<Forum> forumList = repository.findByForumParentId(forum.getForumId());

        assertEquals("Mid-Atlantic Partners", forum.getName());
        assertEquals(2, forumList.size());
    }

    @Test
    void shouldFindByName() {
        Forum forum = repository.findByName("Bridge Climbers");
        assertEquals(5, forum.getForumId());
    }

    @Test
    void shouldFindAllForums() {
        List<Forum> forums = repository.findAll();
        assertEquals(5, forums.size());
    }


    // CREATE tests

    @Test
    @Transactional
    void shouldCreateForum() {
        Forum arg = new Forum();
        arg.setName("Newest Forum");
        arg.setPrimaryForum(true);
        arg.setForumParentId(1);
        arg.setNestLevel(1);

        Forum actual = repository.save(arg);
        assertEquals(6, actual.getForumId());

        actual = repository.findById(6);
        assertEquals("Newest Forum", actual.getName());
    }


    // UPDATE tests

    @Test
    @Transactional
    void shouldUpdateForum() {
        Forum arg = new Forum();
        arg.setForumId(1);
        arg.setName("Changed Name");
        arg.setPrimaryForum(true);
        arg.setForumParentId(0);
        arg.setNestLevel(0);

        Forum actual = repository.save(arg);
        assertEquals("Changed Name", actual.getName());

        actual = repository.findById(1);
        assertEquals("Changed Name", actual.getName());

    }


    // DELETE tests

    @Test
    @Transactional
    void shouldDeleteForum() {
        Forum arg = repository.findById(3);
        assertNotNull(arg);

        repository.deleteById(3);

        arg = repository.findById(3);
        assertNull(arg);
    }
}