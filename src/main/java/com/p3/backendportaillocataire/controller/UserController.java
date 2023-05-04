package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("api/auth")
public class UserController {
        AuthenticationProvider authenticationProvider;

        TokenService tokenService;

        UserService userService;

    public UserController(AuthenticationProvider authenticationProvider, TokenService tokenService, UserService userService) {
        this.authenticationProvider = authenticationProvider;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping(path = "/register")
  public ResponseEntity<Users> register(@RequestBody Users users){
        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                users.getUsername(), users.getPassword()
        ));

        String token = tokenService.generateToken(authentication);

            Users createdUser = userService.registerUser(
                    Users.builder()
                            .email(users.getEmail())
                            .username(users.getUsername())
                            .password(users.getPassword())
                            .created_at(Timestamp.from(Instant.now()))
                            .token(token)
                            .build()
            );


          return new ResponseEntity<>(createdUser, HttpStatus.CREATED);


  }

}
