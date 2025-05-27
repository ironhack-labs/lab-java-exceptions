package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    private PersonsList list;
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp() throws IllegalArgumentException {
        list = new PersonsList();
        person1 = new Person(1, "Alice", "Brown", 28, "Designer");
        person2 = new Person(2, "Charlie", "Black", 33, "Manager");
        list.addPerson(person1);
        list.addPerson(person2);
    }

    @Test
    void testFindByNameValid() {
        try {
            Person found = list.findByName("Charlie Black");
            assertNotNull(found);
            assertEquals("Charlie Black", found.getFullName());
        } catch (IllegalArgumentException e) {
            fail("Exception should not be thrown for valid name format.");
        }
    }

    @Test
    void testFindByNameInvalidFormat() {
        try {
            list.findByName("Charlie");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must be in the format 'FirstName LastName'.", e.getMessage());
        }
    }

    @Test
    void testWritePersonToFile() {
        try {
            list.writePersonToFile(person1, "test_output.txt");
        } catch (Exception e) {
            fail("Should not throw any exception");
        }
    }
}
