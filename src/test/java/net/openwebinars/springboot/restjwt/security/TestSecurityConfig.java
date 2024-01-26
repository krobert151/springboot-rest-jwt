package net.openwebinars.springboot.restjwt.security;


import net.openwebinars.springboot.restjwt.user.model.User;
import net.openwebinars.springboot.restjwt.user.model.UserRole;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Set;

@TestConfiguration
public class TestSecurityConfig {


    @Bean("customUserDetailsService")
    @Primary
    public UserDetailsService userDetailsService() {

        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("robe")
                        .password("{noop}password")
                        .roles(Set.of(UserRole.USER))
                        .build()
        );

    }

}
