package by.epam.training.java.triangle.generator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdGeneratorTest {

    @Test
    public void testGenerateIdShouldBe1() {
        long expected = 1L;
        double actual = IdGenerator.generateId();
        assertEquals(actual, expected, 0.01);
    }

    @Test
    public void testGenerateIdShouldBeNew2() {
        long expected = 1L;
        IdGenerator.setupNewId(100_000);
        IdGenerator.generateId();
        double actual = IdGenerator.generateId();
        assertEquals(actual, expected, 0.01);
    }
}