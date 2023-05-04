package com.p3.backendportaillocataire;
import com.p3.backendportaillocataire.configuration.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class BackendPortailLocataireApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPortailLocataireApplication.class, args);
	}

}
