package com.cognizant.customer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {

    @GetMapping("/customers/{id}")
    public ResponseEntity<Map<String, Object>> getCustomer(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("name", "John Doe");
        response.put("status", "Active");
        return ResponseEntity.ok(response);
    }
}
