package com.cognizant.billing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BillingController {

    @GetMapping("/bills/{customerId}")
    public ResponseEntity<Map<String, Object>> getBill(@PathVariable Long customerId) {
        Map<String, Object> response = new HashMap<>();
        response.put("customerId", customerId);
        response.put("amount", 1250.75);
        response.put("status", "Pending");
        response.put("dueDate", "2026-07-31");
        return ResponseEntity.ok(response);
    }
}
