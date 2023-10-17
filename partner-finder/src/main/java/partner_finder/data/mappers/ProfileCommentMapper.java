package partner_finder.data.mappers;

import partner_finder.models.CommentType;
import partner_finder.models.ProfileComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProfileCommentMapper implements RowMapper<ProfileComment> {

    @Override
    public ProfileComment mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProfileComment comment = new ProfileComment();
        comment.setCommentId(rs.getInt("profile_comment_id"));
        comment.setType(CommentType.PROFILE);
        comment.setSubject(rs.getString("comment_subject"));
        comment.setText(rs.getString("comment_text"));

        String dateTimeStr = rs.getString("posted_date_time");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        comment.setPostedTime(dateTime);

        ClimberMapper climberMapper = new ClimberMapper();
        comment.setReceivingClimber(climberMapper.mapRow(rs, rowNum));

        climberMapper = new ClimberMapper();
        comment.setPostingClimber(climberMapper.mapRow(rs, rowNum));

        return comment;

    }
}
