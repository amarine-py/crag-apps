package models;

import java.time.LocalDateTime;

public class ProfileComment extends Comment {

    private Climber receivingClimber;

    public ProfileComment() {
        super();
    }

    public ProfileComment(int commentId, CommentType type, Climber postingClimber, String subject,
                        String text, LocalDateTime postedTime, Climber receivingClimber) {
        super(commentId, type, postingClimber, subject, text, postedTime);
        this.receivingClimber = receivingClimber;
    }

    public Climber getReceivingClimber() {
        return receivingClimber;
    }

    public void setReceivingClimber(Climber receivingClimber) {
        this.receivingClimber = receivingClimber;
    }
}
