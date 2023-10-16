package models;

import java.time.LocalDateTime;

public class ForumComment extends Comment {

    private Forum forum;

    public ForumComment() {
        super();
    }

    public ForumComment(int commentId, CommentType type, Climber postingClimber, String subject,
                        String text, LocalDateTime postedTime, Forum forum) {

        super(commentId, type, postingClimber, subject, text, postedTime);
        this.forum = forum;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
