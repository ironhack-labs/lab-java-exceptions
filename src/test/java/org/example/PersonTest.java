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
        assertThrows(IllegalArgumentException.class, ()-> {
            person.setAge(0);
        });
    }

    @Test
    void setAgePositive(){
        assertThrows(IllegalArgumentException.class, ()-> {
            person.setAge(5);
        });
    }



}