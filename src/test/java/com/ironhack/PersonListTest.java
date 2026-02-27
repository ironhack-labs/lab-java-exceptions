package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    private PersonList personList;
    private Person person;

    @BeforeEach
    public void setUp() {
        personList = new PersonList();
        person = personList.addPerson("John Doe", 30, "Software Engineer");
    }

    @Test
    void findByName_validName_shouldReturnPerson() throws Exception {
        Person foundPerson = personList.findBynName("John Doe");
        assertEquals("John Doe", foundPerson.getName());
    }

    @Test
    void findByName_invalidName_shouldThrowException() {
        Exception exception = assertThrows(Exception.class, () -> {
            personList.findBynName("Jane Smith");
        });
        assertEquals("Person not found with the name: Jane Smith", exception.getMessage());
    }


    @Test
    void clonePerson_shouldReturnClonedPerson() {
        Person clonedPerson = personList.clonePerson(person);
        assertNotNull(clonedPerson);
        assertEquals(person.getName(), clonedPerson.getName());
        assertEquals(person.getAge(), clonedPerson.getAge());
        assertEquals(person.getOccupation(), clonedPerson.getOccupation());
        assertNotEquals(person.getId(), clonedPerson.getId());
    }

}

