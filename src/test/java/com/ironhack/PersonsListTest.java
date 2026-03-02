package com.ironhack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    @Test
    public void testFindByName_ValidName_ReturnsPerson() {
        PersonsList list = new PersonsList();
        Person p1 = new Person(1, "John Doe", 25, "Analyst");
        list.addPerson(p1);

        Person found = list.findByName("John Doe");
        assertEquals(p1, found);
    }

    @Test
    public void testFindByName_InvalidFormat_ThrowsException() {
        PersonsList list = new PersonsList();


        assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("JohnDoe");
        });
    }
    @Test
    public void testClonePerson(){
        PersonsList list = new PersonsList();
        Person original = new Person(1, "Alice Musk", 49, "Writter");
        Person clone = list.clone(original);

        assertNotEquals(original.getId(), clone.getId());

        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getAge(),  clone.getAge());
        assertEquals(original.getOccupation(), clone.getOccupation());
    }
}