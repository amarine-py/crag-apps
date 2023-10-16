package data.mappers;

import models.Country;
import models.Location;

import models.StateProvince;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setCountry(Country.valueOf(rs.getString("country_id")));
        location.setStateProvince(StateProvince.valueOf(rs.getString("state_province_name")));
        location.setCity(rs.getString("city"));
        location.setPostalCode(rs.getString("postal_code"));
        location.setLocationCode(rs.getInt("location_code"));

        return location;
    }


}
