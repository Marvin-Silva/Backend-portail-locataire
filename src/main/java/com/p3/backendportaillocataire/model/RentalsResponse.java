package com.p3.backendportaillocataire.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//Pour l'affichage de la list de rentals
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RentalsResponse {
    Rental[] rentals;
}
