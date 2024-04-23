package com.example.ecommerce.service;

import com.example.ecommerce.model.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class AuthService {

    public String authenticate(Auth auth) throws ExecutionException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        auth.setReturnSecureToken(true);
        return restTemplate.postForObject("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=", auth, String.class);
    }
}
