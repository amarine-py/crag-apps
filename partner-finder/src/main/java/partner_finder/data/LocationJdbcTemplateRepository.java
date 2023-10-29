package partner_finder.data;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import partner_finder.data.mappers.LocationMapper;
import partner_finder.models.Location;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class LocationJdbcTemplateRepository implements LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    public LocationJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Location findById(int locationId) {
        final String sql = """
                select location_id, country_name, state_province_name, city, postal_code, location_code, enabled
                    from location
                    where location_id = ?;
                """;

        return jdbcTemplate.query(sql, new LocationMapper(), locationId).stream()
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Location> findAll() {
        final String sql = "select * from location;";

        return jdbcTemplate.query(sql, new LocationMapper());
    }

    @Override
    public Location create(Location location) {
        final String sql = """
                insert into location (
                    country_name,
                    state_province_name,
                    city,
                    postal_code,
                    location_code
                    ) values (?, ?, ?, ?, ?);
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, location.getCountry().name());
            ps.setString(2, location.getStateProvince().name());
            ps.setString(3, location.getCity());
            ps.setString(4, location.getPostalCode());
            ps.setInt(5, location.getLocationCode());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        location.setLocationId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return location;
    }

    @Override
    public Location update(Location location) {
        final String sql = """
                update location
                    set
                        country_name = ?,
                        state_province_name = ?,
                        city = ?,
                        postal_code = ?,
                        location_code = ?
                    where location_id = ?;
                """;

        if (jdbcTemplate.update(
                sql,
                location.getCountry().name(),
                location.getStateProvince().name(),
                location.getCity(),
                location.getPostalCode(),
                location.getLocationCode(),
                location.getLocationId()

        ) > 0) {
            return location;
        }

        return null; // update unsuccessful
    }

    @Override
    public boolean enableById(int locationId) {
        Location location = findById(locationId);
        if (location != null) {
            if (!location.isEnabled()) {
                return (jdbcTemplate.update("update location set enabled = true where location_id = ?;", locationId) > 0);
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean disableById(int locationId) {
        Location location = findById(locationId);
        if (location != null) {
            if (location.isEnabled()) {
                return (jdbcTemplate.update("update location set enabled = false where location_id = ?;", locationId) > 0);
            } else {
                return false;
            }
        }
        return false;

    }
    @Override
    public boolean deleteById(int locationId) {
        return jdbcTemplate.update(
                "delete from location where location_id = ?", locationId) > 0;

    }
}
