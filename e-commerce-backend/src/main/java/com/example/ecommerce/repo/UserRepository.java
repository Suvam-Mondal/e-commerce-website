package com.example.ecommerce.repo;

import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);

    @Modifying
    @Query(value = "INSERT INTO users (username, password, role) VALUES (:username, :password, :role)", nativeQuery = true)
    void createNewUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);

}
