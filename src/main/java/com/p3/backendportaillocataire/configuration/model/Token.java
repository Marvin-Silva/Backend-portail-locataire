package com.p3.backendportaillocataire.configuration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Token {
    private String token;
}
