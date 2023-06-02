package com.p3.backendportaillocataire.service;

import com.p3.backendportaillocataire.model.*;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.model.dto.mapper.MapUser;
import com.p3.backendportaillocataire.repository.RentalsRepository;
import com.p3.backendportaillocataire.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final RentalsRepository rentalsRepository;

    private final MapUser mapUser;
    public UserService(UsersRepository usersRepository, RentalsRepository rentalsRepository, MapUser mapUser){
        this.usersRepository = usersRepository;
        this.rentalsRepository = rentalsRepository;
        this.mapUser = mapUser;
    }

    public MessageResponse requestMessage(MessageRequest messageRequest){

        //Get User id
        Optional<Users> user_id = usersRepository.findById(messageRequest.getUser_id());
        //Get Rentals Id
        messageRequest.setRentals_id(new Rental().getId());

        return new MessageResponse("Message send with success");
    }

    public Rental findRentalsByName(String name){
        return rentalsRepository.findByName(name);
    }
    public Users getUserEmail(String email){
        return usersRepository.findByEmail(email);
    }

    //Créer un service pour rentals
    public List<Rental> findAllRentals(){
        return rentalsRepository.findAll();
    }
    public Optional<Rental> findRentalsById(Integer rentalsId){
        return rentalsRepository.findById(rentalsId);
    }
    public RentalResponse createRentals(Rental rental){

                    rentalsRepository.save(rental);

        return new RentalResponse("Rental created");
    }
    public RentalResponse updateRentals(Integer id, Rental rental) {

        if (!rentalsRepository.existsById(id)){
            return new RentalResponse("Rental do not exist");
        }

        rental.setId(id);

        rentalsRepository.save(rental);

        return new RentalResponse("Rental updated !");
    }

    public Optional<UserDto> getUserIdentity(Users user){

         Optional<Users> dto = usersRepository.findById(user.getId());

          Optional<UserDto> userMapped = dto.map(values -> {
             UserDto userDto = UserDto.builder()
                     .id(values.getId())
                     .name(values.getUsername())
                     .email(values.getEmail())
                     .created_at(values.getCreated_at())
                     .updated_at(values.getUpdated_at())
                     .build();

             mapUser.toDto(userDto);
             return userDto;
         });
          return userMapped;
    }
}
