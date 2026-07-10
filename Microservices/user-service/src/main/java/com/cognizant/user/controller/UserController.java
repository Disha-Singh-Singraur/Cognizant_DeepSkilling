package com.cognizant.user.controller;

import com.cognizant.user.client.OrderClient;
import com.cognizant.user.model.OrderDto;
import com.cognizant.user.model.User;
import com.cognizant.user.model.UserDetailsResponse;
import com.cognizant.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final OrderClient orderClient;

    public UserController(UserRepository userRepository, OrderClient orderClient) {
        this.userRepository = userRepository;
        this.orderClient = orderClient;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<UserDetailsResponse> getUserDetails(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    List<OrderDto> orders;
                    try {
                        orders = orderClient.getOrdersByUserId(id);
                    } catch (Exception e) {
                        orders = Collections.emptyList(); // Fallback if Order Service is down
                    }
                    return ResponseEntity.ok(new UserDetailsResponse(user, orders));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
