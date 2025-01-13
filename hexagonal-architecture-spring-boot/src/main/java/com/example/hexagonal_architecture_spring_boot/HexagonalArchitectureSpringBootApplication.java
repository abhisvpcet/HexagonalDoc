package com.example.hexagonal_architecture_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.hexagonal_architecture_spring_boot.infrastructure.feignclient.MovieService")
public class HexagonalArchitectureSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureSpringBootApplication.class, args);
	}

}
