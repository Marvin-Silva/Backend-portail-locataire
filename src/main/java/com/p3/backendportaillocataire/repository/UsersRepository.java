package com.p3.backendportaillocataire.repository;

import com.p3.backendportaillocataire.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    Users findByUsername(String username);
}
