package com.cognizant.junitbasic.exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {
    private final MathUtils utils = new MathUtils();

    @Test
    public void testAdd() {
        assertEquals(5, utils.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, utils.subtract(3, 2));
    }
}
