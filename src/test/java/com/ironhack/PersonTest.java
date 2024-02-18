package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person1;
    @BeforeEach
    void setUp() {
        person1 = new Person("Ada Lovelace", 40, "mathematician");
    }

    @Test
    @DisplayName("Throw error if age is less than zero")
    public void setAge_throwsExceptionWhenNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> person1.setAge(-2));
        assertEquals("Age must be greater than zero", exception.getMessage());
    }

    @Test
    @DisplayName("Two similar Persons are equal")
    public void equals_testSimilarPersons() {
        assertTrue(person1.equals(new Person("Ada Lovelace", 40, "mathematician")));
    }
    @Test
    @DisplayName("Two non similar Persons are different")
    public void equals_testNonSimilarPersons() {
        assertFalse(person1.equals(new Person("Brandon Sanderson", 40, "mathematician")));
        assertFalse(person1.equals(new Person("Ada Lovelace", 32, "mathematician")));
        assertFalse(person1.equals(new Person("Ada Lovelace", 40, "translator")));
    }
}
