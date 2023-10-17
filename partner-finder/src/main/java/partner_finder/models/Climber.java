package partner_finder.models;

import java.time.LocalDate;

public class Climber {

    private int climberId;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Sex climberSex;
    private Location location;
    private ClimberProfile climberProfile;
    private int betaCredits;

    public Climber() {
    }

    public Climber(int climberId, String username, String firstName, String lastName,
                   LocalDate dob, Sex climberSex, Location location, ClimberProfile climberProfile, int betaCredits) {
        this.climberId = climberId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.climberSex = climberSex;
        this.location = location;
        this.climberProfile = climberProfile;
        this.betaCredits = betaCredits;
    }

    public int getClimberId() {
        return climberId;
    }

    public void setClimberId(int climberId) {
        this.climberId = climberId;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ClimberProfile getClimberProfile() {
        return climberProfile;
    }

    public void setClimberProfile(ClimberProfile climberProfile) {
        this.climberProfile = climberProfile;
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
