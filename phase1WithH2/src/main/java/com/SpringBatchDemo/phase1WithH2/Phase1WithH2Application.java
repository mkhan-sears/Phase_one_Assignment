package com.SpringBatchDemo.phase1WithH2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableBatchProcessing
public class Phase1WithH2Application {
 
	
	public static void main(String[] args) {
		SpringApplication.run(Phase1WithH2Application.class, args);
	}

}
