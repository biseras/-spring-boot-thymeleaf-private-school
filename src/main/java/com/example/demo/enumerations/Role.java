package com.example.demo.enumerations;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {

    ROLE_UCENIK, ROLE_PROFESOR, ROLE_ADMINISTRATOR;

    @Override
    public String getAuthority() {
        return name();
    }

}
