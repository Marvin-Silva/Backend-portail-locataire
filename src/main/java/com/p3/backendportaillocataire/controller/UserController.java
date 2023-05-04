package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.configuration.controller.AuthController;
import com.p3.backendportaillocataire.configuration.service.CustomUserDetailsService;
import com.p3.backendportaillocataire.configuration.service.CustomerUserDetails;
import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.OpaqueTokenAuthenticationProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/auth")
public class UserController {

        AuthController authController;
        UserService userService;
        CustomerUserDetails customerUserDetails;

        CustomUserDetailsService customUserDetailsService;

        AuthenticationProvider authenticationProvider;
        TokenService tokenService;

    @PostMapping("/signin")
    public ResponseEntity<Users> login(@RequestBody Users resource){

        resource.setEmail(resource.getEmail());
        resource.setPassword(resource.getPassword());

        Users user = Users.builder().username(resource.getUsername()).build();

        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER_NOT_FOUND");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), resource.getPassword(), List.of());

        try{
            authenticationProvider.authenticate(authenticationToken);
            Users result = user;
            result.setToken(this.tokenService.generateToken(authenticationToken));

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (AuthenticationException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
            e.getMessage());
        }
    }
    @GetMapping("/users")
    public String getUsers(Authentication authentication){

        return "Hello World";
    }

    StringBuffer getUserNamePasswordLoginInfo(Principal user){
        StringBuffer usernameInfo = new StringBuffer();
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken)user);

        if (token.isAuthenticated()){
            User u = (User) token.getPrincipal();
            usernameInfo.append("Welcome, "+ u.getUsername());
        }else {
            usernameInfo.append("NA");
        }
        return usernameInfo;

    }
}
