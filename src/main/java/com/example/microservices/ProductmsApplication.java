package com.example.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableCircuitBreaker
//@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class ProductmsApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "productms");
		SpringApplication.run(ProductmsApplication.class, args);
	}

}
