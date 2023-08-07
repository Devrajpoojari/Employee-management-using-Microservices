package com.firstMC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FirstMcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMcApplication.class, args);
	}

}
