package com.ironhack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAge_ThrowsErrorWhenAgeIsLessThanZero() {
        // Arrange
        Person person = new Person();
        // Assert
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

}