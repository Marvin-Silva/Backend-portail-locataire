package com.p3.backendportaillocataire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "You are logged!!!";
    }
}
