package com.p3.backendportaillocataire.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties("rsa")
public class RsaKeyProperties {
    RSAPublicKey publicKey;
    RSAPrivateKey privateKey;
}
