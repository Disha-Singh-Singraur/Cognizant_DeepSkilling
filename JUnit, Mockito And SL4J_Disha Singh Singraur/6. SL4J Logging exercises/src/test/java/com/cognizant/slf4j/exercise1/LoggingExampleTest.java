package com.cognizant.slf4j.exercise1;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoggingExampleTest {
    @Test
    public void testMain() {
        LoggingExample.main(new String[]{});
        assertTrue(true);
    }
}
