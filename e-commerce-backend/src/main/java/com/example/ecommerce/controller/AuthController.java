package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.model.AuthResponse;
import com.example.ecommerce.security.config.JwtService;
import com.example.ecommerce.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Autowired
    public AuthController(final AuthService authService,
                          final AuthenticationManager authenticationManager,
                          final JwtService jwtService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

  /*  @PostMapping("/new")
    public User createNewUser() {
        log.info("createNewUser() called");
        return authService.newUser();
    }*/

    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@RequestBody User user, HttpServletRequest request) {

        // Extract the "Action" header from the request
        if(request.getHeader("Action").contentEquals("action_signup")) {
            authService.newUser(user);
            log.info("User signed up successfully");
        }

        AuthResponse authResponse = new AuthResponse();

        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailId(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            log.info("Successfully authenticated user {}", user.getEmailId());
            authResponse.setAuthToken(jwtService.generateToken(user.getEmailId()));
            authResponse.setExpiresIn(jwtService.getExpiryTime());
            return  ResponseEntity.ok().body(authResponse);
            //return jwtService.generateToken(user.getEmailId());
        } else {
            log.info("User {} Failed to login", user.getEmailId());
            authResponse.setErrorMessage("User not authenticated");
            return ResponseEntity.badRequest().body(authResponse);
           // return "User not authenticated";
        }
    }


}
