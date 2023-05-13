package com.p3.backendportaillocataire.configuration.service;

import com.p3.backendportaillocataire.configuration.model.Token;
import com.p3.backendportaillocataire.model.Users;
import com.p3.backendportaillocataire.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class TokenService {

    private final JwtEncoder encoder;
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final AuthenticationProvider authenticationProvider;

    public TokenService(JwtEncoder encoder, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationProvider authenticationProvider) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
    }
    public String generateToken(Authentication authentication){

        Instant now = Instant.now();
        // Header access control
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));
        // Payload
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
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
                        buildUser.getUsername(), buildUser.getPassword());

        String token = generateToken(tokenInfo);
        Token tokenObject = Token.builder().token(token).build();
        userRepository.save(buildUser);

        return tokenObject;
    }

    //Implementer
    public Token login(Users users) throws UserPrincipalNotFoundException {
        if (users.getEmail().isBlank()) {
            throw new UserPrincipalNotFoundException("USERNAME NOT FOUND");
        }

        Users user = userRepository.findByEmail(users.getEmail());
        //if (!this.passwordEncoder.matches(resource.getPassword(), user.getPassword())) {

        if (!passwordEncoder.matches(users.getPassword(), user.getPassword())){
            throw new UserPrincipalNotFoundException("USER CREDENTIALS NOT MATCH");
        }

        Users isAuthenticated = Users.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(isAuthenticated.getEmail(), isAuthenticated.getPassword()));

        String token = generateToken(authentication);

        Token tokenObject = Token.builder().token(token).build();

        return tokenObject;
    }

    public Users getUserById(Users user){
      return userRepository.getOne(user.getId());
    }
}