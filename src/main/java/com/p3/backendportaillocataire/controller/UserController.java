package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
