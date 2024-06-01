package com.ironhack;

import junit.framework.TestCase;
import org.junit.Test;

public class PersonTest extends TestCase {

    @Test

    public void testSetAgeThrowsErrorForNegativeAge() {
        Person person = new Person(1, "James",18, "Welder");
        try {
            person.setAge(-5);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be negative", e.getMessage());
        }
    }
}
