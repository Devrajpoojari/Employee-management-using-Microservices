package com.secondMC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class SecondMcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMcApplication.class, args);
	}

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
}
