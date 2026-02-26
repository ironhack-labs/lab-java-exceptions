package com.ironhack.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    private PersonsList list;
    private Person person;
    @BeforeEach
    public void setUp(){
        list = new PersonsList();
        person = new Person("Name Surname", 20, "Engineer");
        list.addPerson(person);
    }
    @Test
    public void testSetAgeThrowsException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {person.setAge(-1);});
    }
    @Test
    public void testFindByNameSuccess(){
        Person found = list.findByName("Name Surname");
        assertNotNull(found);
        assertEquals("Name Surname", found.getName());
    }
    @Test
    public void testFindByNameInvalidFormatThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->
        {list.findByName("NameSurname");});

        assertThrows(IllegalArgumentException.class, () ->
        {list.findByName("Name 123");});
    }
    @Test
    public void testCloneCreatesNewIdWithSameProperties(){
        Person cloned = list.clone(person);

        assertEquals(cloned.getName(), person.getName());
        assertEquals(cloned.getAge(), person.getAge());
        assertEquals(cloned.getOccupation(), person.getOccupation());
        assertNotEquals(cloned.getId(), person.getId());
    }

}
