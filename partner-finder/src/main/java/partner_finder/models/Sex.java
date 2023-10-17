package partner_finder.models;

public enum Sex {

    MALE("Male"),
    FEMALE("Female"),
    NONBINARY("Non-Binary"),
    OTHER("Other");

    private final String sexName;

    Sex(String sexName) {
        this.sexName = sexName;
    }

    public String getSexName() { return sexName; }

    @Override
    public String toString() {
        return "Sex{" +
                "sexName='" + sexName + '\'' +
                '}';
    }
}
