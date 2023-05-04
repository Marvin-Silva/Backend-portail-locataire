package com.p3.backendportaillocataire.controller;

import com.p3.backendportaillocataire.configuration.service.TokenService;
import com.p3.backendportaillocataire.model.*;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api("Api pour les operations d'informations")
@RestController
@RequestMapping("api")
public class UserController {
        AuthenticationProvider authenticationProvider;

        TokenService tokenService;

        UserService userService;

    public UserController(AuthenticationProvider authenticationProvider, TokenService tokenService, UserService userService) {
        this.authenticationProvider = authenticationProvider;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @CrossOrigin("*")
    @GetMapping("/rentals")
    public RentalsResponse getRentalsList(){
       List<Rental> rentals = userService.findAllRentals();
       Rental[] rentalToArray = rentals.toArray(new Rental[rentals.size()]);
       return new RentalsResponse(rentalToArray);
    }

    @CrossOrigin("*")
    @GetMapping("rentals/{id}")
    public Optional<Rental> getRentalsById(@PathVariable(name = "id") Integer rentalsId){
        return userService.findRentalsById(rentalsId);
    }
    @CrossOrigin("*")
    @PostMapping(value = "/rentals")
    public RentalResponse createRentals(MultipartHttpServletRequest request) throws IOException {

        String name = request.getParameter("name");
        int surface = Integer.parseInt(request.getParameter("surface"));
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");

        MultipartFile picture = request.getFile("picture");

        Rental rental = Rental.builder()
                .name(name)
                .surface(surface)
                .price(price)
                .description(description)
                .picture("https://blog.technavio.org/wp-content/uploads/2018/12/"+picture.getOriginalFilename())
                .build();
        return userService.createRentals(rental);
    }

    @CrossOrigin("*")
    @PutMapping("/rentals/{id}")
    public RentalResponse updateRentals(@PathVariable(name = "id") Integer id, @RequestBody Rental rental) {
        return userService.updateRentals(id, rental);
    }

    //messages
    @CrossOrigin("*")
    @PostMapping("/messages")
    public MessageResponse getMessage(@RequestBody MessageRequest messageRequest){

        return userService.requestMessage(messageRequest);
    }
    //user:id
    @CrossOrigin("*")
    @GetMapping("/user/{id}")
    public Optional<UserDto> getUser(Users user){
        return userService.getUserIdentity(user);
    }
}
