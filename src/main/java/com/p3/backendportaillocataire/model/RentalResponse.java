package com.p3.backendportaillocataire.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//Reponse des requettes rentals
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RentalResponse {
    private String message;
}
