package me.bvckslvsh.emarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("qwerty")
                .roles("admin")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("qwerty")
                .roles("user")
                .build();

        UserDetails owner = User.withDefaultPasswordEncoder()
                .username("owner")
                .password("qwerty")
                .roles("owner")
                .build();

        return new InMemoryUserDetailsManager(admin, user, owner);
    }

    @Bean
    public SecurityFilterChain configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable().authorizeHttpRequests()
                .requestMatchers("/content/new").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin();

                return httpSecurity.build();
    }

}
