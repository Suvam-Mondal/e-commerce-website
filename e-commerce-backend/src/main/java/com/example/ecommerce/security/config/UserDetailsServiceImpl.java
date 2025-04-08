package com.example.ecommerce.security.config;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repo.UserRepository;
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
    private UserRepository userRepo;


 /*   @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(emailId);
        if (user == null) {
            log.warn("Invalid username or Password for Email ID " + emailId);
            throw new UsernameNotFoundException("User not found");
        }
        org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(emailId);
        builder.password(user.getPassword());
        builder.roles(user.getRole());
        return builder.build();
    }*/

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(emailId);
        if (user == null) {
            log.info("Invalid username or Password for Email ID " + emailId);
            throw new UsernameNotFoundException(emailId);
        }
        return new UserPrincipal(user);
    }
}
