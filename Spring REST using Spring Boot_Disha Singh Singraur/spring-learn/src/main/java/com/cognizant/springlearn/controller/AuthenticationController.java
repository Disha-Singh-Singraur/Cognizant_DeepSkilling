package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Handout 5: AuthenticationController to handle login and generate JWT tokens
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);

        // Decode basic auth header to extract user
        String user = getUser(authHeader);
        
        // Generate JWT token
        String token = generateJwt(user);

        Map<String, String> result = new HashMap<>();
        result.put("token", token);

        LOGGER.info("END authenticate");
        return result;
    }

    private String getUser(String authHeader) {
        LOGGER.info("START getUser");
        String encodedCredentials = authHeader.replace("Basic ", "").trim();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);

        // Extract username from "username:password" format
        String username = credentials.split(":")[0];
        LOGGER.debug("Decoded Username: {}", username);
        LOGGER.info("END getUser");
        return username;
    }

    private String generateJwt(String user) {
        LOGGER.info("START generateJwt: {}", user);
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        
        // Set the token issue time as current time
        builder.setIssuedAt(new Date());
        
        // Set the token expiry as 20 minutes from now (1200000 milliseconds)
        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        
        String token = builder.compact();
        LOGGER.info("END generateJwt");
        return token;
    }
}
