package com.cognizant.junitadvanced.exercise5;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {
    private final PerformanceTester tester = new PerformanceTester();

    @Test
    public void testPerformTaskTimeout() {
        assertTimeout(Duration.ofMillis(500), () -> {
            tester.performTask();
        });
    }
}
