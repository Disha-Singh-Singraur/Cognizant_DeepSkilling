package com.cognizant.junitadvanced.exercise5;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(50); // Small task duration
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
