package com.p3.backendportaillocataire.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private String message;
    private Integer user_id;
    private Integer rentals_id;
}
