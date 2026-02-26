package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    @Test
    void testSetAgeThrowsException() {
        Person person = new Person(1, "Leo Kennedy", 25, "Developer");
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-5));
    }

    @Test
    void testFindByNameSuccess() {
        PersonsList list = new PersonsList();
        Person p = new Person(1, "Leo Kennedy", 25, "Developer");
        list.add(p);

        Person found = list.findByName("Leo Kennedy");
        assertEquals(p, found);
    }

    @Test
    void testFindByNameWrongFormat() {
        PersonsList list = new PersonsList();
        assertThrows(IllegalArgumentException.class, () -> list.findByName("Leo"));
    }

    @Test
    void testClonePerson() {
        PersonsList list = new PersonsList();
        Person original = new Person(1, "Leo Kennedy", 20, "Developer");

        list.add(original);   // 👈 ADD THIS LINE

        Person cloned = list.clonePerson(original);

        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
    }
}