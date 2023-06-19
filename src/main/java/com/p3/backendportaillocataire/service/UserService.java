package com.p3.backendportaillocataire.service;

import com.p3.backendportaillocataire.model.MessageRequest;
import com.p3.backendportaillocataire.model.MessageResponse;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public MessageResponse requestMessage(MessageRequest messageRequest) {

        MessageRequest request = new MessageRequest();
        request.setUser_id(messageRequest.getUser_id());
        request.setRentals_id(messageRequest.getRentals_id());
        request.setMessage(messageRequest.getMessage());

        return new MessageResponse("Message send with success");
    }

    public Users getUserEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public Optional<UserDto> getUserIdentity(Users user) {
        //Get Users to UserDto
        Optional<Users> dto = usersRepository.findById(user.getId());

        Optional<UserDto> userMapped = dto.map(values -> UserDto.builder()
                .id(values.getId())
                .name(values.getUsername())
                .email(values.getEmail())
                .created_at(values.getCreated_at())
                .updated_at(values.getUpdated_at())
                .build());

        return userMapped;
    }
}
