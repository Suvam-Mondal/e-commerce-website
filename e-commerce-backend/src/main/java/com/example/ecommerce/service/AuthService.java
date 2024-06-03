package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.model.Auth;
import com.example.ecommerce.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class AuthService {

    @Autowired
    UserRepo userRepo;

    public User newUser(User user) {
        return userRepo.save(user);
    }
}
