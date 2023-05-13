package com.p3.backendportaillocataire.configuration.controller;

import com.p3.backendportaillocataire.configuration.model.LoginRequest;
import com.p3.backendportaillocataire.configuration.model.Token;
import com.p3.backendportaillocataire .configuration.service.TokenService;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/auth")
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
        System.out.println("GENATED TOKEN: "+ tokenService.generateToken(authentication));

        String token = tokenService.generateToken(authentication);

        if (token == null){
            return "TOKEN NOT ENCODED: IT IS EQUAL "+token;
        }
       return token;
    }

    @PostMapping("/register")
    public Token register(@RequestBody Users users) throws Exception {
        return tokenService.register(users);
    }

    @PostMapping("/login")
    public Token login(@RequestBody Users users) throws UserPrincipalNotFoundException {
        return tokenService.login(users);
    }
// implementer
    @GetMapping("/me")
    public Users me(@RequestBody Token token, Users userId) throws UserPrincipalNotFoundException {
        String tokenId = login(userId).getToken();

        if (token.getToken().isBlank() || tokenId.isBlank()){
            throw new UserPrincipalNotFoundException("USER NOT FOUND");
        }

        token.setToken(tokenId);

        return tokenService.getUserById(userId);
    }
}
