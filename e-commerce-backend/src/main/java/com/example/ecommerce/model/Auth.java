package com.example.ecommerce.model;

import lombok.Data;

@Data
public class Auth {

    String email;
    String password;
    Boolean returnSecureToken;


}
