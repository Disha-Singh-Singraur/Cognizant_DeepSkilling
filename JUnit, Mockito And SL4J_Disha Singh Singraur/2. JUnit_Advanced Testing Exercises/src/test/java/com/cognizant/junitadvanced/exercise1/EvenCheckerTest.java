package com.cognizant.junitadvanced.exercise1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {
    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10, 100, -2})
    public void testIsEvenWithEvenNumbers(int val) {
        assertTrue(checker.isEven(val));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 15, 99, -5})
    public void testIsEvenWithOddNumbers(int val) {
        assertFalse(checker.isEven(val));
    }
}
