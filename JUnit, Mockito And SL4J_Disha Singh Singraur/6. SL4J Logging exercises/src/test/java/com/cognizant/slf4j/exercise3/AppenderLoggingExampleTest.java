package com.cognizant.slf4j.exercise3;

import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

public class AppenderLoggingExampleTest {
    @Test
    public void testAppenders() {
        // Clean log file before run
        File logFile = new File("app.log");
        if (logFile.exists()) {
            logFile.delete();
        }

        AppenderLoggingExample.logMessages();

        // Check if log file is created and has content
        assertTrue("Log file app.log should be created", logFile.exists());
        assertTrue("Log file should contain content", logFile.length() > 0);
    }
}
