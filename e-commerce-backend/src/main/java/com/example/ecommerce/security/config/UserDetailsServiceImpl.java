package com.example.ecommerce.security.config;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userRepo.findByEmailId(emailId);
        if (user == null) {
            log.info("Invalid username or Password for Email ID " + emailId);
            throw new UsernameNotFoundException(emailId);
        }
        return new UserPrincipal(user);
    }
}
