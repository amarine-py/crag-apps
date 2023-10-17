package partner_finder.data;

import partner_finder.data.mappers.BadgeMapper;
import partner_finder.models.Badge;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

@Repository
public class BadgeJdbcTemplateRepository implements BadgeRepository {

    private final JdbcTemplate jdbcTemplate;

    public BadgeJdbcTemplateRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Badge findById(int badgeId) {
        final String sql = """
                select badge_id, badge_name, badge_description, badge_cost, badge_icon_path, badge_supply
                    from badge
                    where badge_id = ?;
                """;
        return jdbcTemplate.query(sql, new BadgeMapper(), badgeId).stream()
                .findFirst().orElse(null);

    }

    @Override
    public Badge findByName(int badgeName) {
        return null;
    }

    @Override
    public List<Badge> findall() {
        return null;
    }

    @Override
    public Badge create(Badge badge) {
        return null;
    }

    @Override
    public Badge update(Badge badge) {
        return null;
    }

    @Override
    public boolean deleteById(int badgeId) {
        return false;
    }
}
