package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.configuration.service.AuthService;
import com.p3.backendportaillocataire.model.MessageRequest;
import com.p3.backendportaillocataire.model.MessageResponse;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

//Routes pour les users
@RestController
@RequestMapping("api")
public class UserController {
    AuthenticationProvider authenticationProvider;
    AuthService authService;
    UserService userService;

    public UserController(AuthenticationProvider authenticationProvider, AuthService authService, UserService userService) {
        this.authenticationProvider = authenticationProvider;
        this.authService = authService;
        this.userService = userService;
    }
    @CrossOrigin("*")
    @PostMapping("/messages")
    public MessageResponse getMessage(@RequestBody MessageRequest messageRequest){

        return userService.requestMessage(messageRequest);
    }
    @CrossOrigin("*")
    @GetMapping("/user/{id}")
    public Optional<UserDto> getUser(Users user){
        return userService.getUserIdentity(user);
    }
}
