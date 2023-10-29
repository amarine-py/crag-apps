package partner_finder.data;

import partner_finder.models.Location;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationRepository {

    Location findById(int locationId);

    List<Location> findAll();

    Location create(Location location);
    Location update(Location location);

    boolean enableById(int locationId);

    boolean disableById(int locationId);

    @Transactional
    boolean deleteById(int locationId);

}
