package com.cognizant.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public ResponseEntity<Map<String, Object>> secureEndpoint(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "This is a secured endpoint");
        response.put("user", authentication != null ? authentication.getName() : "unknown");
        response.put("authorities", authentication != null ? authentication.getAuthorities() : "none");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/public/info")
    public ResponseEntity<Map<String, String>> publicEndpoint() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "This is a public endpoint, no authentication required");
        return ResponseEntity.ok(response);
    }
}
