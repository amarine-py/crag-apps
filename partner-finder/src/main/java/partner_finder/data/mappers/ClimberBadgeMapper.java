package partner_finder.data.mappers;

import org.springframework.jdbc.core.RowMapper;
import partner_finder.models.ClimberBadge;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClimberBadgeMapper implements RowMapper<ClimberBadge>  {

    @Override
    public ClimberBadge mapRow(ResultSet rs, int rowNum) throws SQLException {

        ClimberBadge climberBadge = new ClimberBadge();
        climberBadge.setClimberBadgeId(rs.getInt("climber_badge_id"));
        climberBadge.setAwardeeId(rs.getInt("awardee_id"));
        climberBadge.setBadgeId(rs.getInt("badge_id"));
        climberBadge.setGiverId(rs.getInt("giver_id"));

        String dateStr = String.valueOf(rs.getDate("date_awarded"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        climberBadge.setDateAwarded(LocalDate.parse(dateStr, formatter));
        climberBadge.setEnabled(rs.getBoolean("is_enabled"));

        return climberBadge;
    }
}
