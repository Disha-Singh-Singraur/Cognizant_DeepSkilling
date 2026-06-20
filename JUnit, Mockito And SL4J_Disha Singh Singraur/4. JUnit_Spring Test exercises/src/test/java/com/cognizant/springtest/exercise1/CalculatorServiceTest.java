package com.cognizant.springtest.exercise1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    private final CalculatorService service = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(5, service.add(2, 3));
    }
}
