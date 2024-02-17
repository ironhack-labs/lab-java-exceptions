package com.ironhack;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    private PersonsList personsList;
    Person person1;
    Person person2;
    Person person3;

    @Before
    public void createData() {
        person1 = new Person(1, "Jane Doe", 18, "Developer");
        person2 = new Person(2, "James Doe", 30, "Product Owner");
        person3 = new Person(2, "John Doe", 50, "Project Manager");
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        personsList = new PersonsList(persons);
    }

    @Test
    public void findByName_Positive() {
        assertEquals(person1, personsList.findByName("Jane Doe"));
    }

    @Test
    public void findByName_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("OnlyFirstName"));
        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("More Than Two Names"));
    }

    @Test
    public void clone_Positive() {
        assertTrue(person1.equals(personsList.clone(person1)));
    }
}