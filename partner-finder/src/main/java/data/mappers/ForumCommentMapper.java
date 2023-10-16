package data.mappers;

import models.CommentType;
import models.ForumComment;
import models.ProfileComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ForumCommentMapper  implements RowMapper<ForumComment> {

    @Override
    public ForumComment mapRow(ResultSet rs, int rowNum) throws SQLException {

        ForumComment comment = new ForumComment();
        comment.setCommentId(rs.getInt("profile_comment_id"));
        comment.setType(CommentType.PROFILE);
        comment.setSubject(rs.getString("comment_subject"));
        comment.setText(rs.getString("comment_text"));

        String dateTimeStr = rs.getString("posted_date_time");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        comment.setPostedTime(dateTime);

        ForumMapper forumMapper = new ForumMapper();
        comment.setForum(forumMapper.mapRow(rs, rowNum));

        ClimberMapper climberMapper = new ClimberMapper();
        comment.setPostingClimber(climberMapper.mapRow(rs, rowNum));

        return comment;

    }
}
