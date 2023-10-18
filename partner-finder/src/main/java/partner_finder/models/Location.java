package partner_finder.models;

import jakarta.persistence.*;

import java.util.Objects;


public class Location {


    private Integer locationId;
    private Country country;
    private StateProvince stateProvince;

    private String city;

    private String postalCode;

    private int locationCode;

    public Location() {

    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
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
                "locationId=" + locationId +
                ", country=" + country +
                ", stateProvince=" + stateProvince +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", locationCode=" + locationCode +
                '}';
    }
}
