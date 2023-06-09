package com.p3.backendportaillocataire.configuration.service;

import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Couche logique qui gere l'authentication utilisateur de springframework
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userService.getUserEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return new CustomerUserDetails(user);
    }
}
