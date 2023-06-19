package com.p3.backendportaillocataire.configuration.controller;

import com.p3.backendportaillocataire.configuration.model.Token;
import com.p3.backendportaillocataire.configuration.service.AuthService;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.model.dto.UserDto;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Api("Api pour les operations d'authentication ")
@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Token register(@RequestBody Users users) throws Exception {
        return authService.register(users);
    }

    @CrossOrigin("*")
    @PostMapping("/login")
    public Token login(@RequestBody Users users) throws UserPrincipalNotFoundException {
        return authService.login(users);
    }

    @CrossOrigin("*")
    @GetMapping("/me")
    public ResponseEntity<UserDto> getMe(Users users){

        return new ResponseEntity<>(authService.getMe(users), HttpStatus.OK);
    }
}