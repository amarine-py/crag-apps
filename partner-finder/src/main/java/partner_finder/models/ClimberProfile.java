package partner_finder.models;

import partner_finder.models.*;

public class ClimberProfile {

    private int profileId;
    private String email;
    private String description;
    private boolean isPublic;
    private String tradGrade;
    private String sportGrade;
    private String boulderGrade;
    private String iceGrade;
    private String mixedGrade;
    private String aidGrade;
    private boolean hasTradGear;
    private boolean hasSportGear;
    private boolean hasRope;
    private boolean hasTransportation;
    private boolean openToMentor;
    private boolean openToMentee;
    private int numPartners;
    private SafetyAttitude safetyAttitude;
    private ClimbingMotivation climbingMotivation;
    private ClimbingStyle climbingStyle;
    private Country climbingCountry;
    private StateProvince climbingState;
    private String climbingPostalCode;
    private ClimbingGym climbingGym;

    public ClimberProfile() {
    }

    public ClimberProfile(int profileId, String email, String description, boolean isPublic, String tradGrade,
                          String sportGrade, String boulderGrade, String iceGrade, String mixedGrade,
                          String aidGrade, boolean hasTradGear, boolean hasSportGear, boolean hasRope,
                          boolean hasTransportation, boolean openToMentor, boolean openToMentee,
                          int numPartners, SafetyAttitude safetyAttitude, ClimbingMotivation climbingMotivation,
                          ClimbingStyle climbingStyle, String climbingPostalCode, Country climbingCountry, StateProvince climbingState, ClimbingGym climbingGym) {
        this.profileId = profileId;
        this.email = email;
        this.description = description;
        this.isPublic = isPublic;
        this.tradGrade = tradGrade;
        this.sportGrade = sportGrade;
        this.boulderGrade = boulderGrade;
        this.iceGrade = iceGrade;
        this.mixedGrade = mixedGrade;
        this.aidGrade = aidGrade;
        this.hasTradGear = hasTradGear;
        this.hasSportGear = hasSportGear;
        this.hasRope = hasRope;
        this.hasTransportation = hasTransportation;
        this.openToMentor = openToMentor;
        this.openToMentee = openToMentee;
        this.numPartners = numPartners;
        this.safetyAttitude = safetyAttitude;
        this.climbingMotivation = climbingMotivation;
        this.climbingStyle = climbingStyle;
        this.climbingPostalCode = climbingPostalCode;
        this.climbingCountry = climbingCountry;
        this.climbingState = climbingState;
        this.climbingGym = climbingGym;
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

    public void setClimbingCountry(Country climbingCountry) {
        this.climbingCountry = climbingCountry;
    }

    public StateProvince getClimbingState() {
        return climbingState;
    }

    public void setClimbingState(StateProvince climbingState) {
        this.climbingState = climbingState;
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

    public SafetyAttitude getSafetyAttitude() {
        return safetyAttitude;
    }

    public void setSafetyAttitude(SafetyAttitude safetyAttitude) {
        this.safetyAttitude = safetyAttitude;
    }

    public ClimbingMotivation getClimbingMotivation() {
        return climbingMotivation;
    }

    public void setClimbingMotivation(ClimbingMotivation climbingMotivation) {
        this.climbingMotivation = climbingMotivation;
    }

    public ClimbingStyle getClimbingStyle() {
        return climbingStyle;
    }

    public void setClimbingStyle(ClimbingStyle climbingStyle) {
        this.climbingStyle = climbingStyle;
    }

    public ClimbingGym getClimbingGym() {
        return climbingGym;
    }

    public void setClimbingGym(ClimbingGym climbingGym) {
        this.climbingGym = climbingGym;
    }

    @Override
    public String toString() {
        return "ClimberProfile{" +
                "profileId=" + profileId +
                ", email='" + email + '\'' +
                '}';
    }
}
