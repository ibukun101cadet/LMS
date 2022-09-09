package io.javabrains.springsecurityjwt.User.registration;

import io.javabrains.springsecurityjwt.User.domain.AppUser;
import io.javabrains.springsecurityjwt.User.domain.Role;
import io.javabrains.springsecurityjwt.User.service.AppUserService;
import io.javabrains.springsecurityjwt.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/library")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private AppUserService userDetailsService;

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody RegistrationRequest registrationRequest) throws Exception {


        userDetailsService.signUpUser(
                new AppUser(
                        registrationRequest.getFirstName(),
                        registrationRequest.getLastName(),
                        registrationRequest.getUserName(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        Role.USER

                ));

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(registrationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);



        return ResponseEntity.ok(new RegistrationResponse(jwt));
    }

}
