package partner_finder.data.mappers;

import partner_finder.models.Badge;
import partner_finder.models.Forum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForumMapper implements RowMapper<Forum> {

    @Override
    public Forum mapRow(ResultSet rs, int rowNum) throws SQLException {
        Forum forum = new Forum();
        forum.setForumId(rs.getInt("forum_id"));
        forum.setName(rs.getString("forum_name"));
        forum.setPrimaryForum(rs.getBoolean("is_primary_forum"));
        forum.setNestLevel(rs.getInt("nest_level"));

        ForumMapper forumMapper = new ForumMapper();
        forum.setParentForum(forumMapper.mapRow(rs, rowNum));

        return forum;

    }
}
