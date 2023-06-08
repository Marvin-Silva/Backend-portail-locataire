package com.p3.backendportaillocataire.repository;


import com.p3.backendportaillocataire.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer> {}
