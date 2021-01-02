package com.cg.farmersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class FarmerSystemApplication {

	private static final Logger logger = LogManager.getLogger(FarmerSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FarmerSystemApplication.class, args);

		logger.info("client class running");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
