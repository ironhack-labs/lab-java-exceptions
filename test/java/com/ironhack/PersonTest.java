package com.ironhack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    @Test
    void testAgeThrowsError(){
       Person person = new Person(1, "Peter Cole", 60, "Farmer");
       assertThrows(IllegalArgumentException.class, ()-> person.setAge(-8));
    }




}