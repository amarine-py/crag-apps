package partner_finder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "climber_badge")
public class ClimberBadge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int climberBadgeId;
    @NotNull(message = "Badge recipient cannot be null.")
    private int awardeeId;
    @NotNull(message = "Badge must have an ID.")
    private int badgeId;
    @NotNull(message = "Badge giver cannot be null.")
    private int giverId;
    private LocalDate dateAwarded;
    private boolean isEnabled;

    public ClimberBadge() {
    }

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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}


