package com.p3.backendportaillocataire.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration Indique à Spring Boot qu'il s'agit d'une classe de configuration
//@EnableWebSecurity Permet spring à savoir où ce trouve la configuration Web
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager configure(AuthenticationManagerBuilder auth)throws Exception{
        return new InMemoryUserDetailsManager(
                User.withUsername("springuser")
                        .password(passwordEncoder().encode("spring123"))
                        .authorities("read")
                        .build()
        );
    }

    //Entrer les filtres
    // Données de la requete http correspondant les entrants

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("api/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
