package models;

import java.time.LocalDateTime;

public class Comment {

    protected int commentId;
    protected CommentType type;
    protected Climber postingClimber;
    protected String subject;
    protected String text;
    protected LocalDateTime postedTime;

    public Comment() {
    }

    public Comment(int commentId, CommentType type, Climber postingClimber, String subject, String text, LocalDateTime postedTime) {
        this.commentId = commentId;
        this.type = type;
        this.postingClimber = postingClimber;
        this.subject = subject;
        this.text = text;
        this.postedTime = postedTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Climber getPostingClimber() {
        return postingClimber;
    }

    public void setPostingClimber(Climber postingClimber) {
        this.postingClimber = postingClimber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }


}
