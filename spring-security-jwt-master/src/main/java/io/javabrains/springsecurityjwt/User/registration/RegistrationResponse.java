package io.javabrains.springsecurityjwt.User.registration;

import java.io.Serializable;

public class RegistrationResponse implements Serializable {

    private final String jwt;

    public RegistrationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
