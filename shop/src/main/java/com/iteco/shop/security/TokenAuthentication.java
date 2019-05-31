package com.iteco.shop.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class TokenAuthentication implements Authentication {
    private final String token;
    private boolean isAuthentication;
    private UserDetails userDetails;

    public TokenAuthentication(String token) {
        this.token = token;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return userDetails;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthentication) throws IllegalArgumentException {
        this.isAuthentication = isAuthentication;
    }

    @Override
    public String getName() {
        return token;
    }
}
