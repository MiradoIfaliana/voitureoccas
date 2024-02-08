package com.dev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception{

        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/statistic/**").permitAll() // gerer statistique ok
            .requestMatchers("/signinlogin/**").permitAll() //  ok
            .requestMatchers("/api/user/**").permitAll() // pour login et inscription 
            .requestMatchers("/api/adminmir/**").permitAll() // admin pour gestion back offic  ok
            .requestMatchers("/transmission/**").permitAll() // gerer transmission
            .requestMatchers("/model/**").permitAll() // gerer model
            .requestMatchers("/marque/**").permitAll() // gerer marque
            .requestMatchers("/categorie/**").permitAll() // gerer categorie
            // .requestMatchers(HttpMethod.GET , "/api/usermir/getMesAnnoces").hasAuthority
            .requestMatchers(HttpMethod.GET , "/api/usermir/getPubAnnonces","/api/usermir/getDetailAnnonce","/api/usermir/getModelsParMarque","/api/usermir/getModelsParMarques").permitAll()
            .requestMatchers(HttpMethod.POST ,"/api/usermir/searchOnPubAnnonce").permitAll()
            // .requestMatchers(HttpMethod.POST , "/api/usermir/creditercompte").permitAll()
            // .requestMatchers(HttpMethod.POST , "/api/usermir/creditercompte").permitAll()
            .anyRequest() //Toute autre 
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
