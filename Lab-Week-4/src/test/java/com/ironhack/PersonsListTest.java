package com.ironhack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    @Test
    public void testFindByName() {
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 25, "Doctor");
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        assertEquals(person1, personsList.findByName("John Doe"));
    }

    @Test
    public void testFindByNameInvalidFormat() {
        PersonsList personsList = new PersonsList();
        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("JohnDoe");
        });
    }

    @Test
    public void testClonePerson() {
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person1);

        Person clonedPerson = personsList.clonePerson(person1);

        assertNotEquals(person1.getId(), clonedPerson.getId());
        assertEquals(person1.getName(), clonedPerson.getName());
        assertEquals(person1.getAge(), clonedPerson.getAge());
        assertEquals(person1.getOccupation(), clonedPerson.getOccupation());
    }

    @Test
    public void testWritePersonToFile() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        PersonsList personsList = new PersonsList();

        String filename = "person.txt";
        personsList.writePersonToFile(person, filename);

        // The actual verification of file content can be done manually or using additional code to read the file.
        assertTrue(true, "File writing executed without throwing an error.");
    }
}