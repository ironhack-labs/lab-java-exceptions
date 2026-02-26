package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    private PersonsList list;
    private Person alice;

    @BeforeEach
    void setUp() {
        list = new PersonsList();
        alice = new Person(100, "Alice Johnson", 28, "Software Engineer");
        list.add(alice);
        list.add(new Person(101, "Bob Smith", 34, "Project Manager"));
    }

    @Test
    @DisplayName("setAge should throw exception when age is negative")
    void testSetAgeNegative() {
        assertThrows(IllegalArgumentException.class, () -> alice.setAge(-5));
        assertEquals(28, alice.getAge()); // age should remain unchanged
    }

    @Test
    @DisplayName("findByName should return correct person")
    void testFindByNameSuccess() {
        Person found = list.findByName("Alice Johnson");
        assertNotNull(found);
        assertEquals(alice.getName(), found.getName());
        assertEquals(alice.getAge(), found.getAge());
    }

    @Test
    @DisplayName("findByName should throw exception on invalid name format")
    void testFindByNameInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> list.findByName("alice johnson"));
        assertThrows(IllegalArgumentException.class, () -> list.findByName("Alice"));
        assertThrows(IllegalArgumentException.class, () -> list.findByName("Alice Johnson Extra"));
        assertThrows(IllegalArgumentException.class, () -> list.findByName(""));
    }

    @Test
    @DisplayName("clone should create person with new id but same properties")
    void testClone() {
        Person original = new Person(500, "Test User", 25, "Tester");
        Person cloned = list.clone(original);

        assertNotEquals(original.getId(), cloned.getId());
        assertTrue(original.equals(cloned));  // our custom equals ignores id
        assertEquals("Test User", cloned.getName());
        assertEquals(25, cloned.getAge());
    }
}