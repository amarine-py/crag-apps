package partner_finder;

import org.springframework.context.annotation.Profile;
import partner_finder.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestHelper {

    public static Location makeLocation(int id) {
        Location location = new Location();
        location.setLocationId(id);
        location.setCountry(Country.UNITED_STATES);
        location.setStateProvince(StateProvince.ARKANSAS);
        location.setCity("Little Rock");
        location.setPostalCode(String.format("%s%s%s%s%s", id, id, id, id, id));

        return location;
    }

    public static ClimberProfile makeProfile(int id) {
        ClimberProfile profile = new ClimberProfile();
        profile.setProfileId(id);
        profile.setClimberId(1);
        profile.setEmail(String.format("profile%s@example.com", id));
        profile.setDescription(String.format("Description of profile #%s", id));
        profile.setLocationId(1);
        profile.setPublic(true);
        profile.setSafetyAttitudeName("IMPORTANT");
        profile.setClimbingMotivationName("NATURE");
        profile.setClimbingCountryName("CANADA");
        profile.setClimbingPostalCode("55555");
        profile.setEnums();

        return profile;

    }

    public static Climber makeClimber(int id) {
        Climber climber = new Climber();
        climber.setClimberId(id);
        climber.setAppUserId(1);
        climber.setUsername(String.format("Climber #%s", id));
        climber.setFirstName(String.format("First%s", id));
        climber.setLastName(String.format("Last%s", id));
        climber.setDob(LocalDate.now().minusYears(id));
        climber.setClimberSex(Sex.FEMALE);
        climber.setEnabled(true);

        return climber;

    }

    public static Badge makeBadge(int id) {
        return new Badge(
                id,
                String.format("Badge #%s name", id),
                String.format("Badge #%s description", id),
                id + 10,
                String.format("Badge #%s icon path", id),
                id + 100,
                true);
    }

    public static ProfileComment makeComment(int id) {
        ProfileComment comment = new ProfileComment();
        comment.setProfileCommentId(id);
        comment.setPostingClimberId(1);
        comment.setReceivingClimberId(2);
        comment.setSubject(String.format("Comment #%s subject", id));
        comment.setText(String.format("Comment #%s text", id));
        comment.setPostedTime(LocalDateTime.now().minusDays(id));
        comment.setEnabled(true);

        return comment;
    }


}
