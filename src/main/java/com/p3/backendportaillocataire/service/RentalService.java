package com.p3.backendportaillocataire.service;

import com.p3.backendportaillocataire.model.Rental;
import com.p3.backendportaillocataire.model.RentalResponse;
import com.p3.backendportaillocataire.repository.RentalsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalsRepository rentalsRepository;

    public RentalService(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    public List<Rental> findAllRentals() {
        return rentalsRepository.findAll();
    }

    public Optional<Rental> findRentalsById(Integer rentalsId) {
        return rentalsRepository.findById(rentalsId);
    }

    public RentalResponse createRentals(Rental rental) {

        rentalsRepository.save(rental);

        return new RentalResponse("Rental created");
    }

    public RentalResponse updateRentals(Integer id, Rental rental) {

        if (!rentalsRepository.existsById(id)) {
            return new RentalResponse("Rental do not exist");
        }

        rental.setId(id);

        rentalsRepository.save(rental);

        return new RentalResponse("Rental updated !");
    }
}
