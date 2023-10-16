package data;

import models.Comment;
import models.CommentType;
import models.ForumComment;
import models.ProfileComment;

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
