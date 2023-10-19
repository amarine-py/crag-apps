package partner_finder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "climbing_gym")
public class ClimbingGym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "climbing_gym_id")
    private int gymId;
    @Column(name = "climbing_gym_name")
    @NotBlank(message = "Name cannot be blank.")
    @Size(max = 75, message = "Cannot be more than 75 characters.")
    private String name;
    @Column(name = "climbing_gym_location_id")
    private int locationId;
    @Transient
    private Location location;
    private boolean enabled;

    public ClimbingGym() {}

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ClimbingGym{" +
                "name='" + name + '\'' +
                '}';
    }

}
