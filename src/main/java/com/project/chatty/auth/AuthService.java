package com.project.chatty.auth;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.chatty.user.User;
import com.project.chatty.user.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(String username, String email, String password) {

        if (userRepository.existsByEmail(email))
            throw new RuntimeException("Email already exists");

        User user = User.builder()
                .username(username)
                .email(email)
                .passwordHash(passwordEncoder.encode(password))
                .createdAt(Instant.now())
                .status("ACTIVE")
                .build();

        userRepository.save(user);

        return jwtUtil.generateToken(user.getId());
    }

    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPasswordHash()))
            throw new RuntimeException("Invalid credentials");

        return jwtUtil.generateToken(user.getId());
    }
}
