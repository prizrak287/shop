package com.iteco.shop.security;

import com.iteco.shop.details.UserDetailsServiceImpl;
import com.iteco.shop.entities.Token;
import com.iteco.shop.services.TokenService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider implements AuthenticationProvider {
    private TokenService tokenService;
    private UserDetailsService userService;

    public JwtTokenProvider(TokenService tokenService, UserDetailsServiceImpl userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication auth = (TokenAuthentication) authentication;
        Token token = tokenService.findOneByValue(auth.getName());
        UserDetails userDetails = userService.loadUserByUsername(token.getUser().getLogin());
        auth.setUserDetails(userDetails);
        auth.setAuthenticated(true);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
