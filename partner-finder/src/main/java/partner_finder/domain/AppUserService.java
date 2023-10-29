package partner_finder.domain;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import partner_finder.data.AppUserRepository;
import partner_finder.models.AppUser;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService{

    private final AppUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    // READ

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = repository.findByUsername(username);

        if (appUser == null || !appUser.isEnabled()) {
            throw new UsernameNotFoundException(String.format("%s not found.", username));
        }

        return appUser;

    }

    public Result<AppUser> add(String username, String password) {
        Result<AppUser> result = validate(username, password);
        if (!result.isSuccess()) {
            return result;
        }

        password = passwordEncoder.encode(password);

        AppUser appUser = new AppUser(0, username, password, true, List.of("USER"));

        result.setPayload(repository.create(appUser));

        return result;
    }

    public Result<AppUser> update(String username) {
        AppUser appUser = loadUserByUsername(username);
        if (appUser == null || !appUser.isEnabled()) {
            throw new UsernameNotFoundException(String.format("%s not found.", username));
        }
        Result<AppUser> result = new Result<>();
        result.setPayload(appUser);

        return result;

    }

    public boolean disableByUsername(String username) {
        return repository.disableByUsername(username);
    }

    private Result<AppUser> validate(String username, String password) {
        Result<AppUser> result = new Result<>();

        if (username == null || username.isBlank()) {
            result.addMessage("username is required", ResultType.INVALID);
        }

        if (password == null || password.isBlank()) {
            result.addMessage("password is required", ResultType.INVALID);
        }

        if (!result.isSuccess()) {
            return result;
        }

        assert username != null;
        if (username.length() > 75) {
            result.addMessage("username must be 75 characters max", ResultType.INVALID);
        }

        assert password != null;
        if (!validatePassword(password)) {
            result.addMessage("password must be at least 8 character and contain a digit, a letter, and a non-digit/non-letter", ResultType.INVALID);
        }

        if (!result.isSuccess()) {
            return result;
        }

        try {
            if (loadUserByUsername(username) != null) {
                result.addMessage("the provided username already exists", ResultType.INVALID);
            }
        } catch (UsernameNotFoundException e) {
            // good!
        }

        return result;
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        int digits = 0;
        int letters = 0;
        int others = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isLetter(c)) {
                letters++;
            } else {
                others++;
            }
        }

        return digits > 0 && letters > 0 && others > 0;
    }


}
