package com.example.ecommerce.model;

import lombok.Data;

import java.util.Date;

@Data
public class AuthResponse {

    String authToken;
    String errorMessage;
    Date expiresIn;

}
