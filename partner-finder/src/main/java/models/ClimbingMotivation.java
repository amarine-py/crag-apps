package models;

public enum ClimbingMotivation {

    ADVENTURE("pursuit of adventure"),
    NATURE("to experience nature"),
    EXERCISE("exercise/fitness"),
    CHALLENGE("to challenge myself"),
    COMPETITION("competition"),
    HOBBY("as a hobby"),
    PASSION("it's my passion"),
    PEOPLE("to meet people"),
    GRADES("to get as good as I can"),
    ZEALOTRY("it's my religion"),
    GOALS("to acheive big climbing goals");

    private String motivation;

    ClimbingMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getMotivation() {
        return motivation;
    }

    @Override
    public String toString() {
        return "ClimbingMotivation{" +
                "motivation='" + motivation + '\'' +
                '}';
    }
}
