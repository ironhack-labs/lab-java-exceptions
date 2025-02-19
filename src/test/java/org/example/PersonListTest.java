package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    private List<Person> personList;
    private PersonList perList;

    @BeforeEach
    public void setUp() {
        personList = new ArrayList<>();

        personList.add(new Person(123456, "Sujeto Prueba", 21, "Data Analyst"));
        personList.add(new Person(398573, "Cristiano Ronaldo", 41, "Football Player"));
        personList.add(new Person(782375, "Neymar Junior", 33, "Football Player"));

        perList = new PersonList(personList);
    }

    @Test
    void findByName_validFormat_samePerson() {
        Person samePerson = perList.findByName("Cristiano Ronaldo");

        assertEquals(personList.get(1), samePerson);
    }

    @Test
    void findByName_invalidFormat_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            perList.findByName("Sujeto");
        });
    }

    @Test
    void findByName_notFoundName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            perList.findByName("Fernando Balseca");
        });
    }

    @Test
    void clone_noParams_newId() {
        Person original = personList.get(0);

        Person clonePerson = new PersonList().clone(original);

        // Same properties as the original
        assertEquals(original.getName(), clonePerson.getName());
        assertEquals(original.getAge(), clonePerson.getAge());
        assertEquals(original.getOccupation(), clonePerson.getOccupation());

        // Different id
        assertNotEquals(original.getId(), clonePerson.getId());
    }
}
