package partner_finder.models;

public enum SafetyAttitude {

    VERY_IMPORTANT("very important"),
    IMPORTANT("important"),
    SOMEWHAT_IMPORTANT("somewhat important"),
    MINIMALLY_IMPORTANT("minimally important"),
    SAFETY_THIRD("safety third");

    private final String safetyAttitude;

    SafetyAttitude(String safetyAttitude) {
        this.safetyAttitude = safetyAttitude;
    }

    public String getSafetyAttitude() {
        return safetyAttitude;
    }

    @Override
    public String toString() {
        return "SafetyAttitude{" +
                "safetyAttitude='" + safetyAttitude + '\'' +
                '}';
    }
}
