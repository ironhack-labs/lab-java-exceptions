package com.ironhack;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person(1, "John Doe", 30, "Software Engineer");
    }

    @Test
    void setAge_validAge_shouldSetAge() {
        person.setAge(25);
        assertEquals(25, person.getAge());
    }


    @Test
    void SetAge_negativeAge_shouldThrowException() {
        try {
            person.setAge(-5);
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be negative", e.getMessage());
        }
    }

    @Test
    void setName_validName_shouldSetName() {
        person.setName("Jane Smith");
        assertEquals("Jane Smith", person.getName());
    }

    @Test
    void setName_emptyName_shouldThrowException() {
        try {
            person.setName("");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null or empty", e.getMessage());
        }
    }

    @Test
    void setName_invalidNameFormat_shouldThrowException() {
        try {
            person.setName("John");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must contain both first and last name", e.getMessage());
        }
    }
}