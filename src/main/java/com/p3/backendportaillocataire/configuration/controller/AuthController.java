package com.p3.backendportaillocataire.configuration.controller;

import com.p3.backendportaillocataire.configuration.model.Token;
import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.model.Users;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.text.ParseException;

@Api("Api pour les operations d'authentication ")
@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationProvider authenticationProvider;

    public AuthController(TokenService tokenService, AuthenticationProvider authenticationProvider) {
        this.tokenService = tokenService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping("/register")
    public Token register(@RequestBody Users users) throws Exception {
        return tokenService.register(users);
    }

    @CrossOrigin("*")
    @PostMapping("/login")
    public Token login(@RequestBody Users users) throws UserPrincipalNotFoundException {
        return tokenService.login(users);
    }
// implementer
    @CrossOrigin("*")
    @GetMapping("/me")
    public ResponseEntity<UserDto> getMe(Authentication auth) throws ParseException {

        return new ResponseEntity<>(tokenService.getMe(auth), HttpStatus.OK);
    }
}