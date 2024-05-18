package com.ironhack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    //com.ironhack.Test the setAge method to ensure that it throws an error if the age is less than 0.
    @Test
    public void testSetAgeThrowsError() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        try {
            person.setAge(-5);
            fail("setAge method should have thrown an error for negative age");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be less than 0", e.getMessage());
        }
    }

}