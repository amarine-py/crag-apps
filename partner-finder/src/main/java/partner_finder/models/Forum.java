package partner_finder.models;

import jakarta.persistence.*;

@Entity(name = "forum")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int forumId;
    @Column(name = "forum_name")
    private String name;
    @Column(name = "is_primary_forum")
    private boolean isPrimaryForum;
//    private Forum parentForum;
    @Column(name="forum_parent_id")
    private int forumParentId;
    @Column(name = "nest_level")
    private int nestLevel;

    public Forum() {
    }

    public Forum(int forumId, String name, boolean isPrimaryForum, int forumParentId, int nestLevel) {
        this.forumId = forumId;
        this.name = name;
        this.isPrimaryForum = isPrimaryForum;
        this.forumParentId = forumParentId;
        this.nestLevel = nestLevel;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrimaryForum() {
        return isPrimaryForum;
    }

    public void setPrimaryForum(boolean primaryForum) {
        isPrimaryForum = primaryForum;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public void setNestLevel(int nestLevel) {
        this.nestLevel = nestLevel;
    }

    public int getForumParentId() {
        return forumParentId;
    }

    public void setForumParentId(int forumParentId) {
        this.forumParentId = forumParentId;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", name='" + name + '\'' +
                ", forumParentId=" + forumParentId +
                '}';
    }
}
