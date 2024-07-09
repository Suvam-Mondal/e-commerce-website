package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableMongoRepositories("com.example.ecommerce.repo")
public class ECommerceApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ECommerceApplication.class, args);
	}

}
