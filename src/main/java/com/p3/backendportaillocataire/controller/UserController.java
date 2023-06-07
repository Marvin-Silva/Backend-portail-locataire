package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.model.MessageRequest;
import com.p3.backendportaillocataire.model.MessageResponse;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("api")
public class UserController {
    AuthenticationProvider authenticationProvider;
    TokenService tokenService;
    UserService userService;

    public UserController(AuthenticationProvider authenticationProvider, TokenService tokenService, UserService userService) {
        this.authenticationProvider = authenticationProvider;
        this.tokenService = tokenService;
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
