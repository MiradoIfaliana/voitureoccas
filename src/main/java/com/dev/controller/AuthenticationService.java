package com.dev.controller;

import com.dev.model.user.Role;
import com.dev.model.user.User;

import java.sql.Date;
import java.util.Hashtable;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.config.JwtService;
import com.dev.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class   AuthenticationService {
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public Hashtable <String,Object> register(RegisterRequest request) {
        Hashtable <String,Object> registerResponse = new Hashtable<>();
        var user = User.builder()
            .nom(request.getFirstName())
            .prenom(request.getLastname())
            .mail(request.getMail())
            .motdepasse(passwordEncoder.encode(request.getPassword()))
            .date(Date.valueOf(request.getDtn()))
            .role(Role.USER)
            .build();
        userRepository.save(user); 
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse tokenObj =AuthenticationResponse.builder()
            .token(jwtToken)
            .build();

        registerResponse.put("status" , 200);
        registerResponse.put("message", "Compte créer !");
        registerResponse.put("data", tokenObj);

        return registerResponse;
    } 

    public Hashtable <String,Object> authenticate(AuthenticationRequest request){
        Hashtable <String,Object> authenticationResponse = new Hashtable<>();
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getMail(), request.getPassword())
            );
            var user = userRepository.findByMail(request.getMail()).orElseThrow(); 
            String jwtToken = jwtService.generateToken(user);
            AuthenticationResponse tokenObj = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
            authenticationResponse.put("status", 200);
            authenticationResponse.put("message", "Vous etes connectée");
            authenticationResponse.put("data", tokenObj);
        } 
        catch (Exception e) {
            authenticationResponse.put("status", 400);
            authenticationResponse.put("message", "Mot de passe ou mail incorectes !");
            authenticationResponse.put("data", "no data");
            return authenticationResponse;
        }
        return authenticationResponse;
    }

}