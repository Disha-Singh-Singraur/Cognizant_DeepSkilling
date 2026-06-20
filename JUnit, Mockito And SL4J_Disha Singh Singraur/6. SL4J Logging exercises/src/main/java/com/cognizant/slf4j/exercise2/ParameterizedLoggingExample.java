package com.cognizant.slf4j.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void logUserLogin(String username, String ipAddress) {
        logger.info("User '{}' successfully logged in from IP address '{}'", username, ipAddress);
    }
}
