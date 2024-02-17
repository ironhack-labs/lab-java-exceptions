package com.ironhack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    private PersonsList personsList;
    Person person1;
    Person person2;
    Person person3;

    @BeforeEach
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
        Person clonedPerson = personsList.clone(person1);
        assertEquals(person1.getName(), clonedPerson.getName());
        assertEquals(person1.getAge(), clonedPerson.getAge());
        assertEquals(person1.getOccupation(), clonedPerson.getOccupation());
        assertNotEquals(person1.getId(), clonedPerson.getId());    }
}