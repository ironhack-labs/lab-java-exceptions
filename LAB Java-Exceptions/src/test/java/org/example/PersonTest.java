package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testSetValidAge() throws IllegalArgumentException {
        Person person = new Person(1, "Lara", "Brown", 25, "Senior Developer");
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    public void testSetAgeInvalid() throws IllegalArgumentException {
        Person person = new Person(2, "Bob", "Green", 40, "Teacher");
        try {
            person.setAge(-1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be less than 0.", e.getMessage());
        }
    }


}