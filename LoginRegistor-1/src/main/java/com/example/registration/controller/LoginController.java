package com.example.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.registration.model.User;
import com.example.registration.repository.UserRepository;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    // Constructor for dependency injection
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String login() {
        return "login"; // Returns the login form view
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {
        // Save the user to the database
        userRepository.save(user);

        // Add user attributes to the model to display on the welcome page
        model.addAttribute("firstname", user.getFname());
        
        // Print for debugging
        System.out.println("User saved: " + user);
        
        return "success"; // Returns the success.html view
    }

    @PostMapping("/login") // Handle login submissions
    public String userLogin(
            @RequestParam("email") String email, 
            @RequestParam("passwd") String passwd, 
            Model model) {
        
        // Find user by email
        User user = userRepository.findByEmail(email);
        
        // Check if user exists and password matches
        if (user != null && user.getPasswd().equals(passwd)) {
            model.addAttribute("firstname", user.getFname());
            return "success"; // Redirect to welcome page on successful login
        } else {
            model.addAttribute("error", "Invalid email or password"); // Add error message for failed login
            return "login"; // Return to login page on failure
        }
    }
}
