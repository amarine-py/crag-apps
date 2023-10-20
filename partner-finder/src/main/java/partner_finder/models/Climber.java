package partner_finder.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Climber {

    private Integer climberId;
    @NotNull(message = "Must be connected to an app user.")
    private Integer appUserId;
    @NotBlank(message = "Must have a username.")
    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters long.")
    private String username;
    @NotNull(message = "Must have a first name.")
    @Size(max = 75, message = "First name must be no longer than 75 characters.")
    private String firstName;
    @NotNull(message = "Must have a last name.")
    @Size(max = 75, message = "Last name must be no longer than 75 characters.")
    private String lastName;
    @Past(message = "Date of birth must be in the past.")
    private LocalDate dob;
    @NotNull(message = "Must select a sex.")
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
