package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person1;
    private Person person2;
    @BeforeEach
    void setUp() {
        person1 = new Person(234566, "Ada Lovelace", 40, "mathematician");
        person2 = new Person(223344, "Hedy Lamarr", 34, "inventor");
    };

    @Test
    @DisplayName("Throw error if age is less than zero")
    public void setAge_throwsExceptionWhenNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> person1.setAge(-2));
        assertEquals("Age must be greater than zero", exception.getMessage());
    }

    @Test
    @DisplayName("Two similar Persons are equal")
    public void equals_testSimilarPersons() {
        assertTrue(person1.equals(new Person(232266, "Ada Lovelace", 40, "mathematician")));
    }
    @Test
    @DisplayName("Two non similar Persons are different")
    public void equals_testNonSimilarPersons() {
        assertFalse(person1.equals(new Person(232266, "Brandon Sanderson", 40, "mathematician")));
        assertFalse(person1.equals(new Person(232266, "Ada Lovelace", 32, "mathematician")));
        assertFalse(person1.equals(new Person(232266, "Ada Lovelace", 40, "translator")));
    }
}
