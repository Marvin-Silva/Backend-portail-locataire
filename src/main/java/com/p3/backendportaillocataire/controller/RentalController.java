package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.model.Rental;
import com.p3.backendportaillocataire.model.RentalResponse;
import com.p3.backendportaillocataire.model.RentalsResponse;
import com.p3.backendportaillocataire.service.RentalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

//Routes pour les rentals
@RestController
@RequestMapping("api")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @CrossOrigin("*")
    @GetMapping("/rentals")
    public RentalsResponse getRentalsList() {
        List<Rental> rentals = rentalService.findAllRentals();
        Rental[] rentalToArray = rentals.toArray(new Rental[rentals.size()]);
        return new RentalsResponse(rentalToArray);
    }

    @CrossOrigin("*")
    @GetMapping("rentals/{id}")
    public Optional<Rental> getRentalsById(@PathVariable(name = "id") Integer rentalsId) {
        return rentalService.findRentalsById(rentalsId);
    }

    @CrossOrigin("*")
    @PostMapping(value = "/rentals")
    public RentalResponse createRentals(MultipartHttpServletRequest request) throws IOException {

        String name = request.getParameter("name");
        int surface = Integer.parseInt(request.getParameter("surface"));
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");

        MultipartFile picture = request.getFile("picture");

        Path folderPath = Paths.get("src/main/resources/static");
        Path filePath = folderPath.resolve(picture.getOriginalFilename());
        picture.transferTo(filePath);

        Rental rental = Rental.builder()
                .name(name)
                .surface(surface)
                .price(price)
                .description(description)
                .picture("http:localhost:8080/"+filePath.getFileName().toString())
                .build();
        return rentalService.createRentals(rental);
    }

    @CrossOrigin("*")
    @PutMapping("/rentals/{id}")
    public RentalResponse updateRentals(@PathVariable(name = "id") Integer id, @RequestBody Rental rental) {
        return rentalService.updateRentals(id, rental);
    }

}
