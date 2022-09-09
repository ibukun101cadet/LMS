package io.javabrains.springsecurityjwt.User.service;

import io.javabrains.springsecurityjwt.User.domain.AppUser;
import io.javabrains.springsecurityjwt.User.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with username %s not found";

    private final UserRepo appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    //private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        return appUserRepository.findByUserName(userName)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, userName)));
    }

    public void signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

    }


    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
