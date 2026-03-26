package com.project.chatty.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> req) {

        String token = authService.register(
                req.get("username"),
                req.get("email"),
                req.get("password")
        );

        return Map.of("accessToken", token);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> req) {

        String token = authService.login(
                req.get("email"),
                req.get("password")
        );

        return Map.of("accessToken", token);
    }
}
