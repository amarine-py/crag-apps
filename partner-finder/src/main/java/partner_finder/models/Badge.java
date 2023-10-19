package partner_finder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "badge")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badgeId;
    @Column(name = "badge_name")
    @NotBlank(message = "Name cannot be blank.")
    @Size(max = 75, message = "Must be under 75 characters.")
    private String name;
    @Column(name = "badge_description")
    @NotBlank(message = "Description cannot be blank.")
    @Size(max = 75, message = "Must be under 1024 characters.")
    private String description;
    @Column(name = "badge_cost")
    @NotNull
    private int cost;
    @Column(name = "badge_icon_path")
    @NotBlank
    private String iconPath;
    @Column(name = "badge_supply")
    private int supply;
    private boolean enabled;

    public Badge() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
