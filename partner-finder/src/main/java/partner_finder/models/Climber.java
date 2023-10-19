package partner_finder.models;

import java.time.LocalDate;

public class Climber {

    private Integer climberId;
    private Integer appUserId;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Sex climberSex;
    private ClimberProfile climberProfile;
    private int betaCredits;
    private boolean enabled;

    public Climber() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getClimberId() {
        return climberId;
    }

    public void setClimberId(Integer climberId) {
        this.climberId = climberId;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Sex getClimberSex() {
        return climberSex;
    }

    public void setClimberSex(Sex climberSex) {
        this.climberSex = climberSex;
    }

    public int getBetaCredits() {
        return betaCredits;
    }

    public void setBetaCredits(int betaCredits) {
        this.betaCredits = betaCredits;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "climberId=" + climberId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
