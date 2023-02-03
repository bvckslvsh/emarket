package me.bvckslvsh.emarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
