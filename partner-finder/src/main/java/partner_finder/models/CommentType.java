package partner_finder.models;

public enum CommentType {

    FORUM("forum comment"),
    PROFILE("profile comment");

    private String name;

    CommentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
