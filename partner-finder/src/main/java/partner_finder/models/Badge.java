package partner_finder.models;

import jakarta.persistence.*;

@Entity(name = "badge")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badgeId;
    @Column(name = "badge_name")
    private String name;
    @Column(name = "badge_description")
    private String description;
    @Column(name = "badge_cost")
    private int cost;
    @Column(name = "badge_icon_path")
    private String iconPath;
    @Column(name = "badge_supply")
    private int supply;

    public Badge() {
    }

    public Badge(int badgeId, String name, String description, int cost, String iconPath, int supply) {
        this.badgeId = badgeId;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.iconPath = iconPath;
        this.supply = supply;
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
