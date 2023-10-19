package partner_finder.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import partner_finder.data.mappers.ClimberMapper;
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
                    climber_id, app_user_id, username, first_name, last_name,
                    birthday, climber_sex_name, beta_credits, enabled
                from climber
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
        args.put("beta_credits", Math.max(climber.getBetaCredits(), 0));
        args.put("enabled", 1);

        int climberId = insert.executeAndReturnKey(args).intValue();
        climber.setClimberId(climberId);

        return climber;
    }

    @Override
    public Climber update(Climber climber) {
        final String sql = """
                update climber set
                    app_user_id = ?,
                    username = ?,
                    first_name = ?,
                    last_name = ?,
                    birthday = ?,
                    climber_sex_name = ?,
                    beta_credits = ?,
                    enabled = ?
                where climber_id = ?;
                """;

        if (jdbcTemplate.update(sql,
                climber.getAppUserId(),
                climber.getUsername(),
                climber.getFirstName(),
                climber.getLastName(),
                climber.getDob(),
                climber.getClimberSex().name(),
                climber.getBetaCredits(),
                (climber.isEnabled()) ? 1 : 0,
                climber.getClimberId()
        ) > 0) {
            return climber;
        }

        return null;
    }

    @Override
    public boolean disableById(int climberId) {
        return (jdbcTemplate.update("update climber set enabled = 0 where climber_id = ?;", climberId) > 0);
    }
    @Override
    public boolean deleteById(int climberId) {
        // WARNING: Climber if an FK in "climber_badge", "profile_comment", and "forum_comment"
        return jdbcTemplate.update("delete from climber where climber_id = ?;",
                climberId) > 0;

    }
}
