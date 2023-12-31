package partner_finder.models;

public enum Country {

    UNITED_STATES("United States"),
    CANADA("Canada"),
    MEXICO("Mexico");

    private final String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() { return countryName; }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                '}';
    }
}
