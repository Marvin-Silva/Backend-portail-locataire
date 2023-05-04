package com.p3.backendportaillocataire.service;

import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Users getUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Users findByEmail(String email){return userRepository.findByEmail(email);}

    public List<Users> findAll(){
        return userRepository.findAll();
    }
}
