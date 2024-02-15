package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    private Person person;
    @BeforeEach
    void setUp() {
        person = new Person(234566, "Ada Lovelace", 40, "mathematician ");
    };

//Test the setAge method to ensure that it throws an error if the age is less than 0.
    @Test
    @DisplayName("Throw error if age is less than zero")
    public void setAge_throwsExceptionWhenNegative() {
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-2));
    }
}
