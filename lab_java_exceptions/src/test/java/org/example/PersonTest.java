package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testFindByNameReturnsCorrectPerson() {
        PersonsList list = new PersonsList();
        list.people = new java.util.ArrayList<>();
        Person p = new Person(1, "Ali Aliyev", 25, "Dev");
        list.people.add(p);

        Person found = list.findByName("Ali Aliyev");
        assertEquals(p, found);
    }

    @Test
    void testCloneMethod() {
        PersonsList list = new PersonsList();
        Person original = new Person(1, "Ali Aliyev", 25, "Dev");
        Person cloned = list.clone(original);

        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
    }
}


