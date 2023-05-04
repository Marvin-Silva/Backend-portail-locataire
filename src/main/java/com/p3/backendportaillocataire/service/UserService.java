package com.p3.backendportaillocataire.service;

import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Users getUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Users registerUser(Users users){
        Users createdUser = userRepository.save(users);
        return createdUser;
    }
}
