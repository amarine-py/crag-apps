package partner_finder.models;

import jakarta.persistence.*;
import partner_finder.models.*;

@Entity(name = "climber_profile")
public class ClimberProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private int climberId;
    @Column(name = "profile_email")
    private String email;
    @Column(name = "profile_description")
    private String description;
    @Column(name = "profile_location_id")
    @Transient
    private int locationId;
    @Transient
    private Location location;
    private boolean isPublic;
    @Column(name = "hardest_trad_grade")
    private String tradGrade;
    @Column(name = "hardest_sport_grade")
    private String sportGrade;
    @Column(name = "hardest_boulder_grade")
    private String boulderGrade;
    @Column(name = "hardest_ice_grade")
    private String iceGrade;
    @Column(name = "hardest_mixed_grade")
    private String mixedGrade;
    @Column(name = "hardest_aid_grade")
    private String aidGrade;
    private boolean hasTradGear;
    private boolean hasSportGear;
    private boolean hasRope;
    private boolean hasTransportation;
    private boolean openToMentor;
    private boolean openToMentee;
    @Column(name = "number_of_registered_partners")
    @Transient
    private int numPartners;
    @Column(name = "primary_safety_attitude_name")
    private String safetyAttitudeName;
    @Transient
    private SafetyAttitude safetyAttitude;
    @Column(name = "primary_climbing_motivation_name")
    private String climbingMotivationName;
    @Transient
    private ClimbingMotivation climbingMotivation;
    @Column(name = "favorite_climbing_style_name")
    private String climbingStyleName;
    @Transient
    private ClimbingStyle climbingStyle;
    @Column(name = "primary_climbing_country_name")
    private String climbingCountryName;
    @Transient
    private Country climbingCountry;
    @Column(name = "primary_climbing_state_province_name")
    private String climbingStateName;
    @Transient
    private StateProvince climbingState;
    @Column(name = "primary_climbing_postal_code")
    private String climbingPostalCode;
    @Column(name = "primary_climbing_gym_id")
    @Transient
    private int climbingGymId;
    private boolean enabled;
    public void setEnums() {
        if (safetyAttitudeName != null) {
            setSafetyAttitude();
        }
        if (climbingMotivationName != null) {
            setClimbingMotivation();
        }
        if (climbingStyleName != null) {
            setClimbingStyle();
        }
        if (climbingCountryName != null) {
            setClimbingCountry();
        }
        if (climbingStateName != null) {
            setClimbingState();
        }
    }

    public ClimberProfile() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getClimberId() {
        return climberId;
    }

    public void setClimberId(int climberId) {
        this.climberId = climberId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getClimbingPostalCode() {
        return climbingPostalCode;
    }

    public void setClimbingPostalCode(String climbingPostalCode) {
        this.climbingPostalCode = climbingPostalCode;
    }

    public Country getClimbingCountry() {
        return climbingCountry;
    }

    public void setClimbingCountry() {

        this.climbingCountry = Country.valueOf(this.getClimbingCountryName());
    }

    public StateProvince getClimbingState() {
        return climbingState;
    }

    public void setClimbingState() {

        this.climbingState = StateProvince.valueOf(this.getClimbingStateName());
    }

    public String getClimbingCountryName() {
        return climbingCountryName;
    }

    public void setClimbingCountryName(String climbingCountryName) {
        this.climbingCountryName = climbingCountryName;
    }

    public String getClimbingStateName() {
        return climbingStateName;
    }

    public void setClimbingStateName() {
        this.climbingStateName = climbingStateName;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getTradGrade() {
        return tradGrade;
    }

    public void setTradGrade(String tradGrade) {
        this.tradGrade = tradGrade;
    }

    public String getSportGrade() {
        return sportGrade;
    }

    public void setSportGrade(String sportGrade) {
        this.sportGrade = sportGrade;
    }

    public String getBoulderGrade() {
        return boulderGrade;
    }

    public void setBoulderGrade(String boulderGrade) {
        this.boulderGrade = boulderGrade;
    }

    public String getIceGrade() {
        return iceGrade;
    }

    public void setIceGrade(String iceGrade) {
        this.iceGrade = iceGrade;
    }

    public String getMixedGrade() {
        return mixedGrade;
    }

    public void setMixedGrade(String mixedGrade) {
        this.mixedGrade = mixedGrade;
    }

    public String getAidGrade() {
        return aidGrade;
    }

    public void setAidGrade(String aidGrade) {
        this.aidGrade = aidGrade;
    }

    public boolean isHasTradGear() {
        return hasTradGear;
    }

    public void setHasTradGear(boolean hasTradGear) {
        this.hasTradGear = hasTradGear;
    }

    public boolean isHasSportGear() {
        return hasSportGear;
    }

    public void setHasSportGear(boolean hasSportGear) {
        this.hasSportGear = hasSportGear;
    }

    public boolean isHasRope() {
        return hasRope;
    }

    public void setHasRope(boolean hasRope) {
        this.hasRope = hasRope;
    }

    public boolean isHasTransportation() {
        return hasTransportation;
    }

    public void setHasTransportation(boolean hasTransportation) {
        this.hasTransportation = hasTransportation;
    }

    public boolean isOpenToMentor() {
        return openToMentor;
    }

    public void setOpenToMentor(boolean openToMentor) {
        this.openToMentor = openToMentor;
    }

    public boolean isOpenToMentee() {
        return openToMentee;
    }

    public void setOpenToMentee(boolean openToMentee) {
        this.openToMentee = openToMentee;
    }

    public int getNumPartners() {
        return numPartners;
    }

    public void setNumPartners(int numPartners) {
        this.numPartners = numPartners;
    }

    public String getSafetyAttitudeName() {
        return safetyAttitudeName;
    }

    public void setSafetyAttitudeName(String safetyAttitudeName) {
        this.safetyAttitudeName = safetyAttitudeName;
    }

    public SafetyAttitude getSafetyAttitude() { return safetyAttitude; }

    public void setSafetyAttitude() {
        safetyAttitude = SafetyAttitude.valueOf(getSafetyAttitudeName());
    }

    public String getClimbingMotivationName() {
        return climbingMotivationName;
    }

    public void setClimbingMotivationName(String climbingMotivationName) {
        this.climbingMotivationName = climbingMotivationName;
    }

    public ClimbingMotivation getClimbingMotivation() {
        return climbingMotivation;
    }

    public void setClimbingMotivation() {
        this.climbingMotivation = ClimbingMotivation.valueOf(this.getClimbingMotivationName());
    }

    public String getClimbingStyleName() {
        return climbingStyleName;
    }

    public void setClimbingStyleName(String climbingStyleName) {
        this.climbingStyleName = climbingStyleName;
    }

    public ClimbingStyle getClimbingStyle() {
        return climbingStyle;
    }

    public void setClimbingStyle() {
        this.climbingStyle = ClimbingStyle.valueOf(this.getClimbingStyleName());
    }

    public int getClimbingGymId() {
        return climbingGymId;
    }

    public void setClimbingGymId(int climbingGymId) {
        this.climbingGymId = climbingGymId;
    }

    @Override
    public String toString() {
        return "ClimberProfile{" +
                "profileId=" + profileId +
                ", climberId=" + climberId +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", locationId=" + locationId +
                ", isPublic=" + isPublic +
                ", tradGrade='" + tradGrade + '\'' +
                ", sportGrade='" + sportGrade + '\'' +
                ", boulderGrade='" + boulderGrade + '\'' +
                ", iceGrade='" + iceGrade + '\'' +
                ", mixedGrade='" + mixedGrade + '\'' +
                ", aidGrade='" + aidGrade + '\'' +
                ", hasTradGear=" + hasTradGear +
                ", hasSportGear=" + hasSportGear +
                ", hasRope=" + hasRope +
                ", hasTransportation=" + hasTransportation +
                ", openToMentor=" + openToMentor +
                ", openToMentee=" + openToMentee +
                ", numPartners=" + numPartners +
                ", safetyAttitudeName='" + safetyAttitudeName + '\'' +
                ", safetyAttitude=" + safetyAttitude +
                ", climbingMotivationName='" + climbingMotivationName + '\'' +
                ", climbingMotivation=" + climbingMotivation +
                ", climbingStyleName='" + climbingStyleName + '\'' +
                ", climbingStyle=" + climbingStyle +
                ", climbingCountryName='" + climbingCountryName + '\'' +
                ", climbingCountry=" + climbingCountry +
                ", climbingStateName='" + climbingStateName + '\'' +
                ", climbingState=" + climbingState +
                ", climbingPostalCode='" + climbingPostalCode + '\'' +
                ", climbingGymId=" + climbingGymId +
                ", enabled=" + enabled +
                '}';
    }
}
