package com.example.securitydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitydemo.entity.AppUser;
import com.example.securitydemo.repository.UserRepository;
import com.example.securitydemo.dto.UserRequestDTO; // Corrected import

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Show welcome message (available publicly)
    @GetMapping("/public/welcome")
    public String getWelcome() {
        return "Welcome to our Hotel";
    }

    // Add handler for "/" landing page after login
    @GetMapping("/")
    public String home() {
        return "Welcome to our Hotel! You are logged in.";
    }

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
            return ResponseEntity.status(409).body("User already exists");
        }

        AppUser user = new AppUser();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(userRequest.getRole() != null ? "ROLE_" + userRequest.getRole().toUpperCase() : "ROLE_USER");

        userRepository.save(user);

        return ResponseEntity.status(201).body("User Registered Successfully");
    }

    @GetMapping("/api/user/userinfo")
    public String getVoucher() {
        return "Your voucher code is generated:";
    }

    @GetMapping("/api/admin/admininfo")
    public String getUserInfo() {
        return "Admin dashboard will get open";
    }
}
