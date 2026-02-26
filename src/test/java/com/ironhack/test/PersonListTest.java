package com.ironhack.test;

import com.ironhack.Person;
import com.ironhack.PersonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    private PersonList personList;
    private Person testPerson;

    @BeforeEach
    void setUp() {
        personList = new PersonList();
        testPerson = new Person(1, "John Doe", 25, "Software Engineer");
        personList.addPerson(testPerson);
    }

    @Test
    void setAge_negativeAge_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            testPerson.setAge(-1);
        }, "Should throw IllegalArgumentException when age is negative");
    }

    @Test
    void findByName_validName_shouldReturnCorrectPerson() {
        Person found = personList.findByName("John Doe");

        assertNotNull(found, "The person should be found in the list");
        assertEquals("John Doe", found.getName(), "The names must match exactly");
    }

    @Test
    void findByName_invalidFormat_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName("JohnDoe");
        }, "Should throw IllegalArgumentException when name format is incorrect");
    }
    @Test
    void clone_validPerson_shouldCreateNewIdWithSameProperties() {
        int newId = 101;
        Person cloned = personList.clone(testPerson, newId);

        assertNotEquals(testPerson.getId(), cloned.getId(), "Cloned ID should be different from the original");
        assertEquals(newId, cloned.getId(), "Cloned ID must match the provided new ID");

        assertEquals(testPerson.getName(), cloned.getName(), "Names should be identical");
        assertEquals(testPerson.getAge(), cloned.getAge(), "Ages should be identical");
        assertEquals(testPerson.getOccupation(), cloned.getOccupation(), "Occupations should be identical");

        assertTrue(testPerson.equals(cloned), "Equals should return true as it ignores the ID");
    }
}