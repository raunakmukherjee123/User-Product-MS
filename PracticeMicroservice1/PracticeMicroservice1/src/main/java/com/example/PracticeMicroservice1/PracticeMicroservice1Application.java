package com.example.PracticeMicroservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PracticeMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(PracticeMicroservice1Application.class, args);
	}

}
