package partner_finder.models;

import java.util.Objects;

public class Location {

    private int locationId;
    private Country country;
    private StateProvince stateProvince;
    private String city;
    private String postalCode;
    private int locationCode;

    public Location(int locationId, Country country, StateProvince stateProvince, String city, String postalCode, int locationCode) {
        this.locationId = locationId;
        this.country = country;
        this.stateProvince = stateProvince;
        this.city = city;
        this.postalCode = postalCode;
        this.locationCode = locationCode;
    }

    public Location() {

    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public StateProvince getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(StateProvince stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId == location.locationId && locationCode == location.locationCode && country == location.country && stateProvince == location.stateProvince && Objects.equals(city, location.city) && Objects.equals(postalCode, location.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, country, stateProvince, city, postalCode, locationCode);
    }

    @Override
    public String toString() {
        return "Location{" +
                "country=" + country +
                ", stateProvince=" + stateProvince +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
