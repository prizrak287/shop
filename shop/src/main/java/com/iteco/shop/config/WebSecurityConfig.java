package com.iteco.shop.config;

import com.iteco.shop.security.JwtTokenProvider;
import com.iteco.shop.security.TokenAuthFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@ComponentScan("com.iteco.shop")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider provider;
    private final TokenAuthFilter filter;

    public WebSecurityConfig(JwtTokenProvider provider, TokenAuthFilter filter) {
        this.provider = provider;
        this.filter = filter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(filter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(provider)
                .authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/login").permitAll();
        http.csrf().disable();
    }
}
