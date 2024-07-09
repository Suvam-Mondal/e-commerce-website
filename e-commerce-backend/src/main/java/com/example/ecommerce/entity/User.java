package com.example.ecommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Column(unique = true, nullable = false, name = "emailId")
    @Id
    String emailId;

    @Column(nullable = false, name = "password")
    String password;

    @Column(nullable = false, name = "role")
    String role;

}
