package data.mappers;

import models.Badge;
import models.ClimbingGym;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClimbingGymMapper implements RowMapper<ClimbingGym> {

    @Override
    public ClimbingGym mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClimbingGym climbingGym = new ClimbingGym();
        climbingGym.setGymId(rs.getInt("climbing_gym_id"));
        climbingGym.setName(rs.getString("climbing_gym_name"));

        LocationMapper locationMapper = new LocationMapper();
        climbingGym.setLocation(locationMapper.mapRow(rs, rowNum));

        return climbingGym;

    }
}
