package partner_finder.data;

import partner_finder.data.BadgeJdbcTemplateRepository;
import partner_finder.models.Badge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BadgeJdbcTemplateRepositoryTest {

    @Autowired
    BadgeJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }


    // READ tests

    @Test
    void shouldFindById() {
        Badge actualOne = repository.findById(1);
        assertEquals("Expert Belayer", actualOne.getName());
    }

    @Test
    void findByName() {
    }

    @Test
    void findall() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}