package partner_finder.data;

import partner_finder.models.Location;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationRepository {

    Location findById(int locationId);
//    List<Location> findByCountryId(int countryId);
//    List<Location> findByStateId(int stateId);
//    List<Location> findByPostalCode(String postalCode);
//    List<Location> findByLocationCode(int locationCode);
    List<Location> findAll();

    Location create(Location location);
    Location update(Location location);

    @Transactional
    boolean deleteById(int locationId);

}
