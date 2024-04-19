package com.example.ecommerce.controller;

import com.example.ecommerce.model.Auth;
import com.example.ecommerce.model.OrderPayment;
import com.example.ecommerce.service.AuthService;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }


    @PostMapping()
    public String authenticate(@RequestBody Auth auth) throws ExecutionException, InterruptedException {

        return authService.authenticate(auth);
    }



}
