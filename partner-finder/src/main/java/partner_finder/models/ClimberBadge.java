package partner_finder.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "climber_badge")
public class ClimberBadge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int climberBadgeId;
    private int awardeeId;
    private int badgeId;
    private int giverId;
    private LocalDate dateAwarded;

    public int getClimberBadgeId() {
        return climberBadgeId;
    }

    public void setClimberBadgeId(int climberBadgeId) {
        this.climberBadgeId = climberBadgeId;
    }

    public int getAwardeeId() {
        return awardeeId;
    }

    public void setAwardeeId(int awardeeId) {
        this.awardeeId = awardeeId;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public int getGiverId() {
        return giverId;
    }

    public void setGiverId(int giverId) {
        this.giverId = giverId;
    }

    public LocalDate getDateAwarded() {
        return dateAwarded;
    }

    public void setDateAwarded(LocalDate dateAwarded) {
        this.dateAwarded = dateAwarded;
    }
}


