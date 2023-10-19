//package partner_finder.data.mappers;
//
//import partner_finder.models.Badge;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class BadgeMapper implements RowMapper<Badge> {
//
//    @Override
//    public Badge mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Badge badge = new Badge();
//        badge.setBadgeId(rs.getInt("badge_id"));
//        badge.setName(rs.getString("badge_name"));
//        badge.setDescription(rs.getString("badge_description"));
//        badge.setCost(rs.getInt("badge_cost"));
//        badge.setIconPath(rs.getString("badge_icon_path"));
//        badge.setSupply(rs.getInt("badge_supply"));
//
//        return badge;
//
//    }
//}
