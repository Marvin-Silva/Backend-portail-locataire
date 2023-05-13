package com.p3.backendportaillocataire.service;

import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Users getUserEmail(String email){
        return userRepository.findByEmail(email);
    }

}
