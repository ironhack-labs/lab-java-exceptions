package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testSetAge() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        person.setAge(30);
        assertEquals(30, person.getAge());

        // Test throwing exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
        assertEquals("Age cannot be less than 0", exception.getMessage());
    }

    @Test
    public void testFindByName() {
        PersonList.PersonsList personsList = new PersonList.PersonsList();
        Person john = new Person(1, "John Doe", 25, "Engineer");
        personsList.addPerson(john);

        // Test finding person by name
        Person foundPerson = personsList.findByName("John Doe");
        assertEquals(john, foundPerson);

        // Test throwing exception for improperly formatted name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("John");
        });
        assertEquals("Name must be formatted as 'firstName lastName'", exception.getMessage());
    }

    @Test
    public void testClonePerson() {
        PersonList.PersonsList personsList = new PersonList.PersonsList();
        Person john = new Person(1, "John Doe", 25, "Engineer");
        personsList.addPerson(john);

        // Test cloning
        Person clonedJohn = personsList.clone(john);
        assertEquals(john, clonedJohn);
    }
}
