package com.p3.backendportaillocataire;

import com.p3.backendportaillocataire.configuration.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
@EnableSwagger2
public class BackendPortailLocataireApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendPortailLocataireApplication.class, args);
	}
	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.p3.backendportaillocataire")).build();
	}
}
