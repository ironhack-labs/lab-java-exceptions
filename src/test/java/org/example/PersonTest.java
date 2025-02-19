package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAge_ThrowsException_ForNegativeValues() {
        Person person = new Person();
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
    }
}