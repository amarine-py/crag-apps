package partner_finder.models;

public class ClimbingGym {

    private int gymId;
    private String name;
    private Location location;

    public ClimbingGym() {};
    public ClimbingGym(int gymId, String name, Location location) {
        this.gymId = gymId;
        this.name = name;
        this.location = location;
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
