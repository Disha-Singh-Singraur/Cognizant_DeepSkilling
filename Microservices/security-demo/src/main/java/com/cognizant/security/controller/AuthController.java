package com.cognizant.security.controller;

import com.cognizant.security.jwt.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> generateToken(@RequestBody Map<String, String> credentials) {
        String username = credentials.getOrDefault("username", "user");
        String token = jwtTokenProvider.generateToken(username);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("type", "Bearer");
        response.put("username", username);
        return ResponseEntity.ok(response);
    }
}
