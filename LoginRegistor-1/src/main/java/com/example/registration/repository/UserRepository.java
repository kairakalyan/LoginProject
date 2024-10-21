package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Change findByUsername to findByEmail to match the User class
    User findByEmail(String email);
    
}
