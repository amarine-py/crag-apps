package partner_finder.data;

import partner_finder.models.Comment;
import partner_finder.models.CommentType;
import partner_finder.models.ForumComment;
import partner_finder.models.ProfileComment;

import java.util.List;

public interface CommentRepository {

    Comment findById(int commentId);
    List<Comment> findByClimberId(int climberId);
    List<Comment> findByForumId(int forumId);

    List<Comment> findAllByType(CommentType type);

    Comment create(Comment comment);
    Comment update(Comment comment);
    boolean deleteById(int commentId);

}
