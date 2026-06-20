package com.cognizant.slf4j.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void logMessages() {
        logger.debug("Debug log going to console and file appenders.");
        logger.info("Info log going to console and file appenders.");
    }
}
