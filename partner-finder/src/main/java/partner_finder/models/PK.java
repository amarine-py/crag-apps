package partner_finder.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

public class PK implements Serializable {

    private int awardeeId;
    private int badgeId;

    public PK(int awardeeId, int badgeId) {
        this.awardeeId = awardeeId;
        this.badgeId = badgeId;
    }

    private PK() {}

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

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PK pk = (PK) obj;
        return Objects.equals(awardeeId, pk.awardeeId) &&
                Objects.equals(badgeId, pk.badgeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardeeId, badgeId);
    }

}
