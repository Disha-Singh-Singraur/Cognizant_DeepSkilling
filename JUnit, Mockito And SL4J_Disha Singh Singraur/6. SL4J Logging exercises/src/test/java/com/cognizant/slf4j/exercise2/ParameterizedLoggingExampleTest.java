package com.cognizant.slf4j.exercise2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ParameterizedLoggingExampleTest {
    @Test
    public void testLogging() {
        ParameterizedLoggingExample.logUserLogin("johndoe", "192.168.1.50");
        assertTrue(true);
    }
}
