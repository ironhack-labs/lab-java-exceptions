package com.ironhack;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Faker fk = new Faker();
    @Test
    public void given_Age_when_Negative_then_ThrowErr() {

        var person1 = new Person(1, fk.name().fullName(), 43, fk.job().position());
        try {
            person1.setAge(-5);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Age must be a positive integer", e.getMessage());
        }


    }
}