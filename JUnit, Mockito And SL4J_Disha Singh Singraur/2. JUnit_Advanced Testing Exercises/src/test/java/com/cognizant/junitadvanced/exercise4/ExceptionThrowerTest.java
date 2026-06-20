package com.cognizant.junitadvanced.exercise4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testExceptionThrown() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> thrower.throwException()
        );
        assertEquals("Invalid input data.", ex.getMessage());
    }
}
