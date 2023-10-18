package partner_finder.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import partner_finder.data.mappers.ClimberMapper;
import partner_finder.data.mappers.LocationMapper;
import partner_finder.models.Climber;

import java.util.HashMap;
import java.util.List;

@Repository
public class ClimberJdbcTemplateRepository implements ClimberRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClimberJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Climber findById(int climberId) {
        final String sql = """
                select
                    c.climber_id, c.app_user_id, c.username, c.first_name, c.last_name,
                    c.birthday, c.climber_sex_name, c.climber_primary_location_id,
                    c.climber_profile_id, c.beta_credits,
                    l.location_id, l.country_name, l.state_province_name, l.city,
                    l.postal_code, l.location_code,
                    cp.profile_id, cp.profile_email, cp.profile_description, cp.is_public,
                    cp.hardest_trad_grade, cp.hardest_sport_grade, cp.hardest_boulder_grade,
                    cp.hardest_ice_grade, cp.hardest_mixed_grade, cp.hardest_aid_grade,
                    cp.has_trad_gear, cp.has_sport_gear, cp.has_rope, cp.has_transportation,
                    cp.open_to_mentor, cp.open_to_mentoring, cp.number_of_registered_partners,
                    cp.primary_safety_attitude_name, cp.primary_climbing_motivation_name,
                    cp.favorite_climbing_style_name, cp.primary_climbing_country_name,
                    cp.primary_climbing_state_province_name, cp.primary_climbing_postal_code,
                    cp.primary_climbing_gym_id
                from climber c
                inner join location l on c.climber_primary_location_id = l.location_id
                inner join climber_profile cp on c.climber_profile_id = cp.profile_id
                where climber_id = ?;
                """;

        return jdbcTemplate.query(sql, new ClimberMapper(), climberId).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Climber> findAll() {
        return jdbcTemplate.query("select * from climber;", new ClimberMapper());

    }

    @Override
    public Climber create(Climber climber) {

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("climber")
                .usingGeneratedKeyColumns("climber_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("app_user_id", climber.getAppUserId());
        args.put("username", climber.getUsername());
        args.put("first_name", climber.getFirstName());
        args.put("last_name", climber.getLastName());
        args.put("birthday", climber.getDob());
        args.put("climber_sex_name", climber.getClimberSex().name());
//        if (climber.getLocation().getLocationId() != null) {
//            args.put("climber_primary_location_id", climber.getLocation().getLocationId());
//        } else {
//            args.put("climber_primary_location_id", 0);
//        }
//        if (climber.getClimberProfile().getProfileId() != null) {
//            args.put("climber_profile_id", climber.getClimberProfile().getProfileId());
//        } else {
//            args.put("climber_profile_id", 0);
//        }
        args.put("beta_credits", Math.max(climber.getBetaCredits(), 0));

        int climberId = insert.executeAndReturnKey(args).intValue();
        climber.setClimberId(climberId);

        return climber;
    }

    @Override
    public Climber update(Climber climber) {
        return null;
    }

    @Override
    public boolean deleteById(int climberId) {
        return false;
    }
}
