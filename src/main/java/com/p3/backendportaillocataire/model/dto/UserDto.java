package com.p3.backendportaillocataire.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

//Cible les données des users
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private Timestamp created_at;
    private Timestamp updated_at;
}
