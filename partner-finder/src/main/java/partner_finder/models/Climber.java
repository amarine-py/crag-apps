package partner_finder.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Climber {

    private Integer climberId;
    @NotNull(message = "Must be connected to an app user.")
    private Integer appUserId;
    @Email(message = "Must be a valid email address.")
    @Size(max = 75, message = "Email must be no longer than 75 characters.")
    @NotBlank(message = "Email cannot be blank.")
    @Column(name = "email")
    private String email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", appUserId=" + appUserId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", climberSex=" + climberSex +
                ", enabled=" + enabled +
                '}';
    }
}
