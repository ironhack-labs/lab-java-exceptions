package org.example;

import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @BeforeEach
    void setUpPerson() {
        person = new Person(10, "Hugo Sanchez", 27, "Delantero");
    }


    @Test
    @DisplayName("Check setName() throws exception")
    void testAge() {
        assertThrows (IllegalArgumentException.class, () -> person.setAge(-1));
        assertDoesNotThrow(()->person.setAge(18));

    }

}