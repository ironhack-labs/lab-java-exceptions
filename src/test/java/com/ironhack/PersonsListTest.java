package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    private PersonsList list;
    private Person person1;

    @BeforeEach
    void setUp() {
        person1 = new Person("Ada Lovelace", 40, "mathematician");
        Person person2 = new Person("Hedy Lamarr", 34, "inventor");
        list = new PersonsList();
        list.add(person1);
        list.add(person2);
    }

    @Test
    @DisplayName("Finds and return Person that exists in the list")
    public void findByName_existingPersonInTheList() {
        assertEquals(person1, list.findByName("Ada Lovelace"));
    }
    @Test
    @DisplayName("Finds and return null when there's no Person with the name in the list")
    public void findByName_nonExistingNameOfPersonInTheList() {
        assertNull(list.findByName("Brandon Sanderson"));
    }

    @Test
    @DisplayName("Throw error if name is not properly formatted")
    public void findByName_throwsExceptionWhenNotProperlyFormatted() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> list.findByName("AdaLovelace"));
        assertEquals("Name is not properly formatted: 'firstName lastName'", exception.getMessage());
    }

    @Test
    @DisplayName("Clone creates a new Person object with the same properties except the id")
    public void clone_allPropertiesExceptId() {
        Person personCloned = list.clone(person1);
        assertTrue(person1.equals(personCloned));
        assertNotEquals(person1.getId(), personCloned.getId());
    }
}
