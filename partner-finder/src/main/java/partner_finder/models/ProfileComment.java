package partner_finder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
@Entity(name = "profile_comment")
public class ProfileComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileCommentId;
    @Column(name = "posting_climber_id")
    @Positive(message = "ID of posting climber must be set.")
    private int postingClimberId;
    @Positive(message = "ID of receiving climber must be set.")
    @Column(name = "receiving_climber_id")
    private int receivingClimberId;
    @Transient
    private Climber postingClimber;
    @Transient
    private Climber receivingClimber;
    @Column(name = "comment_subject")
    @NotBlank(message = "Subject cannot be blank.")
    @Size(max = 256, message = "Subject limited to 256 characters.")
    private String subject;
    @Column(name = "comment_text")
    @NotBlank(message = "Comment must have a body.")
    @Size(max = 2048, message = "Comment is limited to 2048 characters.")
    private String text;
    @Column(name = "posted_date_time")
    private String postedTimeString;
    @Transient
    @PastOrPresent
    private LocalDateTime postedTime;
    private boolean enabled;


    public ProfileComment() {
    }

    public int getProfileCommentId() {
        return profileCommentId;
    }

    public void setProfileCommentId(int profileCommentId) {
        this.profileCommentId = profileCommentId;
    }

    public int getPostingClimberId() {
        return postingClimberId;
    }

    public void setPostingClimberId(int postingClimberId) {
        this.postingClimberId = postingClimberId;
    }

    public int getReceivingClimberId() {
        return receivingClimberId;
    }

    public void setReceivingClimberId(int receivingClimberId) {
        this.receivingClimberId = receivingClimberId;
    }

    public Climber getPostingClimber() {
        return postingClimber;
    }

    public void setPostingClimber(Climber postingClimber) {
        this.postingClimber = postingClimber;
    }

    public Climber getReceivingClimber() {
        return receivingClimber;
    }

    public void setReceivingClimber(Climber receivingClimber) {
        this.receivingClimber = receivingClimber;
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

    public String getPostedTimeString() {
        return postedTimeString;
    }

    public void setPostedTimeString(String postedTimeString) {
        this.postedTimeString = postedTimeString;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
