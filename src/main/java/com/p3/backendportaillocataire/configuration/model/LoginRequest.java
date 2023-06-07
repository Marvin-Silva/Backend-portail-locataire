package com.p3.backendportaillocataire.configuration.model;

import com.p3.backendportaillocataire.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {
    private String username;
    private String password;
}