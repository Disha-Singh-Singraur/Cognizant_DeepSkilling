package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Handout 5: SecurityConfig class setting up Spring Security rules (Spring Boot 3 modern style)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    // PasswordEncoder configuration
    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Start passwordEncoder");
        return new BCryptPasswordEncoder();
    }

    // In-memory authentication configuration
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        LOGGER.info("Start userDetailsService");
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("pwd"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("pwd"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    // Security filter chain configuration
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        LOGGER.info("Start filterChain");
        
        http.csrf(csrf -> csrf.disable())
                .httpBasic(basic -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/countries").hasRole("USER")
                        .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilter(new JwtAuthorizationFilter(authenticationManager));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
