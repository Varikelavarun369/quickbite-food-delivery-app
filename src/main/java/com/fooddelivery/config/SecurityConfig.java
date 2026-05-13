package com.fooddelivery.config;

import com.fooddelivery.security.CustomUserDetailsService;
import com.fooddelivery.security.JwtAuthFilter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService
            customUserDetailsService;

    @Autowired
    private JwtAuthFilter
            jwtAuthFilter;

    @Bean
    public SecurityFilterChain
    securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .cors(cors -> cors.configurationSource(
                        corsConfigurationSource()))

                .authorizeHttpRequests(auth -> auth


                        .requestMatchers(
                                "/auth/**",
                                "/users/**"
                        )
                        .permitAll()


                        .requestMatchers(
                                HttpMethod.GET,
                                "/restaurants/**"
                        )
                        .hasAnyAuthority(
                                "CUSTOMER",
                                "ADMIN"
                        )


                        .requestMatchers(
                                HttpMethod.POST,
                                "/restaurants/**"
                        )
                        .hasAuthority("ADMIN")


                        .requestMatchers(
                                "/orders/**"
                        )
                        .hasAnyAuthority(
                                "CUSTOMER",
                                "ADMIN"
                        )

                        .anyRequest()
                        .authenticated()
                )

                .sessionManagement(session ->

                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authenticationProvider(
                        authenticationProvider())

                .addFilterBefore(
                        jwtAuthFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder
    passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider
    authenticationProvider() {

        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(
                customUserDetailsService);

        authProvider.setPasswordEncoder(
                passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager
    authenticationManager(
            AuthenticationConfiguration config)
            throws Exception {

        return config.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource
    corsConfigurationSource() {

        CorsConfiguration configuration =
                new CorsConfiguration();

        configuration.setAllowedOrigins(
                List.of("*"));

        configuration.setAllowedMethods(
                List.of("*"));

        configuration.setAllowedHeaders(
                List.of("*"));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                configuration);

        return source;
    }
}