package data;

import models.AppUser;
import org.springframework.transaction.annotation.Transactional;

public interface AppUserRepository {
    @Transactional
    AppUser findByUsername(String email);

    @Transactional
    AppUser create(AppUser user);

    @Transactional
    boolean update(AppUser user);

    @Transactional
    boolean deleteByUsername(String username);

}
