package com.example.eureka_serveur;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServeurApplication.class, args);
	}

}
