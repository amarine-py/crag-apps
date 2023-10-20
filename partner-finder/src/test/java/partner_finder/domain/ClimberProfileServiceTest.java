package partner_finder.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import partner_finder.data.ClimberProfileRepository;
import partner_finder.data.ClimberProfileRepository;
import partner_finder.models.ClimberProfile;
import partner_finder.models.ClimberProfile;
import partner_finder.models.Country;
import partner_finder.models.ClimberProfile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static partner_finder.TestHelper.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClimberProfileServiceTest {

    @MockBean
    ClimberProfileRepository repository;

    @Autowired
    ClimberProfileService service;

    // READ

    @Test
    void shouldFindProfileById() {
        ClimberProfile profile = makeProfile(1);
        when(repository.findById(1)).thenReturn(profile);
        ClimberProfile actual = service.findById(1);

        assertEquals(String.format("profile%s@example.com", actual.getProfileId()), actual.getEmail());
    }

    // CREATE

    @Test
    void shouldCreateNewProfile() {
        ClimberProfile newProfile = makeProfile(0);
        ClimberProfile expected = makeProfile(1);
        when(repository.save(newProfile)).thenReturn(expected);
        Result<ClimberProfile> result = service.create(newProfile);

        assertEquals("profile1@example.com", expected.getEmail());

    }

    @Test
    void shouldNotCreateInvalidProfile() {
        ClimberProfile profile = new ClimberProfile();
        profile.setClimbingCountry(Country.MEXICO);
        Result<ClimberProfile> result = service.create(profile);
        System.out.println(result);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotCreateWithDuplicateEmail() {
        ClimberProfile profile1 = makeProfile(1);
        ClimberProfile profile2 = makeProfile(2);
        profile2.setEmail("profile1@example.com");
        when(repository.findByEmail("profile1@example.com")).thenReturn(profile1);
        Result<ClimberProfile> result = service.create(profile1);
        System.out.println(result);
        assertFalse(result.isSuccess());
    }

    // UPDATE

    @Test
    void shouldUpdateHasTradGear() {
        ClimberProfile newProfile = makeProfile(1);
        when(repository.save(newProfile)).thenReturn(newProfile);
        Result<ClimberProfile> result = service.create(newProfile);

        assertFalse(result.getPayload().isHasTradGear());

        newProfile.setHasTradGear(true);
        result = service.update(newProfile);

        assertTrue(result.getPayload().isHasTradGear());

    }

    @Test
    void shouldNotUpdateWith3Messages() {
        ClimberProfile comment = new ClimberProfile();
        Result<ClimberProfile> result = service.update(comment);
        System.out.println(result);
        assertEquals(3, result.getMessages().size());
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