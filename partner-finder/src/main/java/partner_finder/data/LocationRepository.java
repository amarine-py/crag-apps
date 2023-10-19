package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
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

    boolean disableById(int locationId);

    @Transactional
    boolean deleteById(int locationId);

}
