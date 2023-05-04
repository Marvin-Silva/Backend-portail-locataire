package com.p3.backendportaillocataire.configuration.service;

import com.p3.backendportaillocataire.configuration.model.Token;
import com.p3.backendportaillocataire.model.dto.UserDto;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private final JwtEncoder encoder;

    private final JwtDecoder decoder;
    private final UsersRepository usersRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final AuthenticationProvider authenticationProvider;

    private final UserDetailsService userDetailsService;

    public TokenService(JwtEncoder encoder, JwtDecoder decoder, UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationProvider authenticationProvider, UserDetailsService userDetailsService) {
        this.encoder = encoder;
        this.decoder = decoder;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.userDetailsService = userDetailsService;
    }
    public String generateToken(Users users){

        Instant now = Instant.now();
        // Header access control
        /*
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));
        */

        // Payload
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(users.getEmail())
                .claim("scope", "")
                .build();

        // Signature
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public Token register(Users users) throws UserPrincipalNotFoundException {
        Users buildUser = Users.builder()
                .email(users.getEmail())
                .username(users.getUsername())
                .password(passwordEncoder.encode(users.getPassword()))
                .created_at(Timestamp.from(Instant.now()))
                .build();

        if (buildUser.getEmail().isBlank() || buildUser.getUsername().isBlank() || buildUser.getPassword().isBlank()){
            throw new UserPrincipalNotFoundException("USER NOT VALID");
        }

        Authentication tokenInfo =
                new UsernamePasswordAuthenticationToken(
                        buildUser.getEmail(), buildUser.getPassword());

        String token = generateToken(buildUser);
        Token tokenObject = Token.builder().token(token).build();
        usersRepository.save(buildUser);

        return tokenObject;
    }

    //Implementer
    public Token login(Users users) throws UserPrincipalNotFoundException {

        if (users.getEmail().isBlank()) {
            throw new UserPrincipalNotFoundException("USERNAME NOT FOUND");
        }

        Users user = usersRepository.findByEmail(users.getEmail());
        //if (!this.passwordEncoder.matches(resource.getPassword(), user.getPassword())) {

        if (!passwordEncoder.matches(users.getPassword(), user.getPassword())){
            throw new UserPrincipalNotFoundException("USER CREDENTIALS NOT MATCH");
        }

        Users isAuthenticated = Users.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(isAuthenticated.getEmail(), isAuthenticated.getPassword()));

        getAuth(authentication);

        String token = generateToken(user);

        Token tokenObject = Token.builder().token(token).build();

        return tokenObject;
    }
    //Plutot dans le controller
    public UserDto getMe(Authentication authentication) {
        Users user = usersRepository.findByEmail(authentication.getName());

        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .created_at(user.getCreated_at())
                .updated_at(user.getUpdated_at())
                .build();

        return userDto;

    }
    private Authentication getAuth(Authentication authentication){
        return authentication;
    }

}