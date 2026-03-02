package com.ironhack;

import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.Test;

public class PersonTest {


    @Test
    public void testSetAge_ValidAge() {

        Person person  = new Person(1, "John Doe", 25, "Developer");
        Assertions.assertEquals(25, person.getAge());
    }

    @Test
    public void testSetAge_NegativeAge_ThrowsException() {
        Person  person = new Person(1, "John Doe", 25, "Developer");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
              person.setAge(-1);

        });
    }

    @Test

    public void testEquals_SamePropertiesDifferentId_ReturnsTrue() {
        Person p1 = new Person(1, "Jane Smith", 30, "Doctor");

        Person p2 = new Person(2, "Jane Smith", 30, "Doctor");
        Assertions.assertEquals(p1, p2);
    }

    @Test
    public void testEquals_DifferentProperties_ReturnsFalse() {
        Person p1 = new Person(1, "Jane Smith", 30, "Doctor");

        Person p2 = new Person(1,  "Jane Smith", 31, "Doctor");



        Assertions.assertNotEquals(p1, p2);
    }




}