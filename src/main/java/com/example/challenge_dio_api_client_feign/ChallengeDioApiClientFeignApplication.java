package com.example.challenge_dio_api_client_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ChallengeDioApiClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeDioApiClientFeignApplication.class, args);
	}

}
