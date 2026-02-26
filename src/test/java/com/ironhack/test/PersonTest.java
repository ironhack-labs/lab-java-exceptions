package com.ironhack.test;

import com.ironhack.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void setAge_negativeAge_shouldThrowIllegalArgumentException() {
        Person person = new Person(1, "John Doe", 20, "Developer");

        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        }, "Setting a negative age should throw an exception");
    }

    // 2. Test setAge works correctly for valid ages
    @Test
    void setAge_validAge_shouldUpdateAge() {
        Person person = new Person(1, "John Doe", 20, "Developer");
        person.setAge(35);

        assertEquals(35, person.getAge(), "The age should be updated to 35");
    }
    @Test
    void equals_samePropertiesDifferentId_shouldReturnTrue() {
        Person person1 = new Person(1, "Jane Doe", 28, "Designer");
        Person person2 = new Person(2, "Jane Doe", 28, "Designer");

        assertTrue(person1.equals(person2), "Persons with same name, age, and occupation should be equal");
    }
    @Test
    void equals_differentProperties_shouldReturnFalse() {
        Person person1 = new Person(1, "Jane Doe", 28, "Designer");
        Person person2 = new Person(1, "Jane Doe", 30, "Manager");

        assertFalse(person1.equals(person2), "Persons with different age or occupation should not be equal");
    }
}