package com.example.ecommerce;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@SpringBootApplication
@EnableMongoRepositories("com.example.ecommerce.repo")
public class ECommerceApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ECommerceApplication.class, args);
	}

}
