package com.p3.backendportaillocataire.configuration.model;

import com.p3.backendportaillocataire.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginRequest extends Users {
    private String username;
    private String password;
}
