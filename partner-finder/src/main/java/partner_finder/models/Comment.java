package partner_finder.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int commentId;
    @Transient
    protected CommentType type;
    @Column(name = "posting_climber_id")
    protected int postingClimberId;
    @Transient
    protected Climber postingClimber;
    @Column(name = "comment_subject")
    protected String subject;
    @Column(name = "comment_text")
    protected String text;
    @Column(name = "posted_date_time")
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

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }
}
