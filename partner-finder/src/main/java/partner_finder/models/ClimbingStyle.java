package partner_finder.models;

public enum ClimbingStyle {

    TRAD("trad climbing"),
    SPORT("sport climbing"),
    BOULDERING("bouldering"),
    ALPINE("alpine climbing"),
    ICE("ice climbing"),
    MIXED("mixed climbing"),
    GYM_BOULDERING("bouldering in the gym"),
    GYM_TOP_ROPING("top roping in the gym"),
    GYM_LEAD_CLIMBING("lead climbing in the gym");

    private final String climbingStyle;

    ClimbingStyle(String climbingStyle) {
        this.climbingStyle = climbingStyle;
    }

    public String getClimbingStyle() {
        return climbingStyle;
    }

    @Override
    public String toString() {
        return "ClimbingStyle{" +
                "climbingStyle='" + climbingStyle + '\'' +
                '}';
    }
}
