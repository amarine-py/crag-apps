package data;

import data.mappers.BadgeMapper;
import models.Badge;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
public class BadgeJdbcTemplateRepository implements BadgeRepository {

    private final JdbcTemplate jdbcTemplate;

    public BadgeJdbcTemplateRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

       @Override
    public Badge findById(int badgeId) {
        return null;
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
