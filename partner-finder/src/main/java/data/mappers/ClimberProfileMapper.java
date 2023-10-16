package data.mappers;

import models.Climber;
import models.ClimberProfile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClimberProfileMapper implements RowMapper<ClimberProfile> {

    @Override
    public ClimberProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClimberProfile climberProfile = new ClimberProfile();
        return climberProfile;
    }
}
