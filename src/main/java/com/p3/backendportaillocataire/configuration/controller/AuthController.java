package com.p3.backendportaillocataire.configuration.controller;

import com.p3.backendportaillocataire.configuration.model.LoginRequest;
import com.p3.backendportaillocataire .configuration.service.TokenService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationProvider authenticationProvider;

    public AuthController(TokenService tokenService, AuthenticationProvider authenticationProvider) {
        this.tokenService = tokenService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody LoginRequest loginRequest){
       Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return tokenService.generateToken(authentication);
    }
}
