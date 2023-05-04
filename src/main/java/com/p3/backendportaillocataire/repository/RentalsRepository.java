package com.p3.backendportaillocataire.repository;


import com.p3.backendportaillocataire.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer> {
    Rental findByName(String name);

    Rental save(MultipartFile file);
}
