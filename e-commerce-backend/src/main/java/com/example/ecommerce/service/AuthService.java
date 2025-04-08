package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AuthService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @Transactional
    public void newUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userRepo.createNewUser(user.getUsername(), encodedPassword, user.getRole());
    }
}
