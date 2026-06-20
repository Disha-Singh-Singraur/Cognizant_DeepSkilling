package com.cognizant.junitbasic.exercise4;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAATest {
    private Calculator calculator;

    @Before
    public void setUp() {
        // Arrange
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testMultiply() {
        // Act
        int result = calculator.multiply(3, 4);

        // Assert
        assertEquals(12, result);
    }
}
