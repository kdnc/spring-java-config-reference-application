package com.nuwan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
/**
 * Extends WebSecurityConfigurerAdapter and overrides a couple of its methods to set some
 * specifics of the web security configuration.
 */
public class BasicSecuringWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Defines which URL paths should be secured and which should not.
        // Specifically, "/security/basic-securing-web/" must be authenticated.
        // When a user successfully logs in, they will be redirected to the previously requested page that requires authentication.
        http.
             authorizeRequests()
                .antMatchers("/security/basic-securing-web/admin")
                .access("hasRole('ROLE_USER')")
                .and()
             .formLogin()
                .loginPage("/security/basic-securing-web/login")
                .permitAll()
                .and()
             .logout()
                .permitAll();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // sets up an in-memory user store with a single user. That user is given a
        // username of "user", a password of "password", and a role of "USER".
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
