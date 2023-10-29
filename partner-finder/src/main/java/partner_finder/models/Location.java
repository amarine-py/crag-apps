package partner_finder.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;


public class Location {


    private int locationId;
    @NotNull(message = "Country is required.")
    private Country country;
    @NotNull(message = "State or province is required.")
    private StateProvince stateProvince;
    @NotBlank(message = "City is required.")
    @Size(max = 75, message = "City name cannot be longer than 75 characters.")
    private String city;
    @NotBlank(message = "Postal code cannot be blank.")
    @Size(max = 12, message = "Postal code cannot be longer than 12 characters.")
    private String postalCode;
    private int locationCode;
    private boolean enabled;
    public Location() {

    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
                "locationId=" + locationId +
                ", country=" + country +
                ", stateProvince=" + stateProvince +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", locationCode=" + locationCode +
                '}';
    }
}
