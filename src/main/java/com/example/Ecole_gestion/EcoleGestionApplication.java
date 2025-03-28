package com.example.Ecole_gestion;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EcoleGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoleGestionApplication.class, args);
	}

}
