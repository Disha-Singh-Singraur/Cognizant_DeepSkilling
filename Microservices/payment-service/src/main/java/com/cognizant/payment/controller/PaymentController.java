package com.cognizant.payment.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private static final String PAYMENT_SERVICE = "paymentService";

    @GetMapping("/payments/{id}")
    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "paymentFallback")
    public ResponseEntity<Map<String, Object>> processPayment(@PathVariable Long id) {
        logger.info("Processing payment for id: {}", id);
        // Simulate a slow or failing external call
        if (id % 3 == 0) {
            throw new RuntimeException("Simulated payment processor failure for id: " + id);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("paymentId", id);
        response.put("status", "SUCCESS");
        response.put("amount", 500.00);
        response.put("message", "Payment processed successfully");
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Map<String, Object>> paymentFallback(@PathVariable Long id, Throwable throwable) {
        logger.warn("Circuit breaker triggered for payment id: {}. Reason: {}", id, throwable.getMessage());
        Map<String, Object> fallbackResponse = new HashMap<>();
        fallbackResponse.put("paymentId", id);
        fallbackResponse.put("status", "SERVICE_UNAVAILABLE");
        fallbackResponse.put("message", "Payment service is currently unavailable. Please try again later.");
        return ResponseEntity.ok(fallbackResponse);
    }
}
