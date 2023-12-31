package partner_finder.data.mappers;

import partner_finder.models.Climber;

import partner_finder.models.Sex;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ClimberMapper implements RowMapper<Climber> {

    @Override
    public Climber mapRow(ResultSet rs, int rowNum) throws SQLException {
        Climber climber = new Climber();
        climber.setClimberId(rs.getInt("climber_id"));
        climber.setAppUserId(rs.getInt("app_user_id"));
        climber.setEmail(rs.getString("email"));
        climber.setFirstName(rs.getString("first_name"));
        climber.setLastName(rs.getString("last_name"));
        climber.setDob(rs.getDate("birthday").toLocalDate());
        climber.setClimberSex(Sex.valueOf(rs.getString("climber_sex_name")));
        climber.setBetaCredits(rs.getInt("beta_credits"));
        climber.setEnabled((rs.getInt("enabled")) > 0);

        return climber;
    }
}
