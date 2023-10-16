package models;

public class Forum {

    private int forumId;
    private String name;
    private boolean isPrimaryForum;
    private Forum parentForum;
    private int nestLevel;

    public Forum() {
    }

    public Forum(int forumId, String name, boolean isPrimaryForum, Forum parentForum, int nestLevel) {
        this.forumId = forumId;
        this.name = name;
        this.isPrimaryForum = isPrimaryForum;
        this.parentForum = parentForum;
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

    public Forum getParentForum() {
        return parentForum;
    }

    public void setParentForum(Forum parentForum) {
        this.parentForum = parentForum;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public void setNestLevel(int nestLevel) {
        this.nestLevel = nestLevel;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", name='" + name + '\'' +
                ", parentForum=" + parentForum +
                '}';
    }
}
