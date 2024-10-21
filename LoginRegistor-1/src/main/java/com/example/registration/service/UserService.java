package com.example.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.model.User;
import com.example.registration.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Authenticate using email and password
    public boolean authenticate(String email, String passwd) {
        User user = userRepository.findByEmail(email); // Use email for lookup
        return user != null && user.getPasswd().equals(passwd); // Match password
    }
}
