package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person = new Person(2, "nam name", 20, "jjj");
    @Test
    void setAgeLessZero(){
        assertThrows(IllegalArgumentException.class, ()-> {
            person.setAge(-2);
        });
    }

    @Test
    void setAgeZero(){
        person.setAge(0);
        assertEquals(0, person.getAge());

    }

    @Test
    void setAgePositive(){
        assertDoesNotThrow(()-> {
            person.setAge(5);
        });
    }



}