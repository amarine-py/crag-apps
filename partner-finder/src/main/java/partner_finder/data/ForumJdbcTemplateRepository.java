package partner_finder.data;

import org.springframework.jdbc.core.JdbcTemplate;
import partner_finder.data.mappers.ForumMapper;
import partner_finder.models.Forum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForumJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    ForumJdbcTemplateRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Integer> findChildrenById(int forumId) {
        final String sql = """
                select * from forum
                    where forum_parent_id = ?;
                """;
        ArrayList<Integer> forumChildrenIds = jdbcTemplate.query(sql, new ForumMapper(), forumId)
                .stream().map( (f) -> f.getForumId()).collect(Collectors.toCollection(ArrayList::new));

        return forumChildrenIds;


    }
}
