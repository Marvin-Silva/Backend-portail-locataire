package com.p3.backendportaillocataire.model;

import lombok.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @Column(name = "name")
    private String username;
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String token;

    UserDetails userDetails;

    public static Users from(User user) {
        Users userResource = new Users();
        userResource.setUsername(user.getUsername());
        return userResource;
    }
}
