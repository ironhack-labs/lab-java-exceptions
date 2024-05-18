package com.ironhack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    //Test the findByName method to ensure that it properly finds and returns the correct Person object when given a properly formatted name.
    @Test
    public void testFindByName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 25, "Doctor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        Person foundPerson = personsList.findByName("John Doe");
        assertNotNull(foundPerson);
        assertEquals(person1, foundPerson);

        foundPerson = personsList.findByName("Jane Smith");
        assertNotNull(foundPerson);
        assertEquals(person2, foundPerson);

        foundPerson = personsList.findByName("Invalid Name");
        assertNull(foundPerson); // Expecting null for a name that doesn't exist in the list
    }

    //Test the findByName method to ensure that it throws an exception if the name parameter is not properly formatted.
    @Test
    public void testFindByNameThrowsError() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        personsList.addPerson(person1);

        try {
            personsList.findByName("Invalid Name Format");
            fail("findByName method should have thrown an error for invalid name format");
        } catch (IllegalArgumentException e) {
            assertEquals("Name should be formatted as 'firstName lastName'", e.getMessage());
        }
    }

    //Test the clone method to ensure that it creates a new Person object with the same properties as the original, except with a new id.
    @Test
    public void testClone() {
        PersonsList personsList = new PersonsList();
        Person originalPerson = new Person(1, "John Doe", 30, "Engineer");
        int newId = 2; // New id for the cloned person
        Person clonedPerson = personsList.clone(originalPerson, newId);

        // Ensure the properties are the same
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());

        // Ensure the new id is different
        assertNotEquals(originalPerson.getId(), clonedPerson.getId());
        assertEquals(newId, clonedPerson.getId());
    }
}