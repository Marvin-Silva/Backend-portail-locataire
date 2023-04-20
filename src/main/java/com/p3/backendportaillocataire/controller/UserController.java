package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.model.Users;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/auth")
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "You are logged!!!";
    }

    @GetMapping("/login/users")
    public String getUserInfo(Principal user){
        StringBuffer userInfo = new StringBuffer();

        if (user instanceof UsernamePasswordAuthenticationToken){
            userInfo.append(getUserNamePasswordLoginInfo(user));
        }else if (user instanceof AbstractOAuth2TokenAuthenticationToken){
            userInfo.append("TOKEN NOT IMPLEMENTED");
        }
        return userInfo.toString();
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
