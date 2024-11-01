package com.example.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientserviceApplication.class, args);
	}

}
