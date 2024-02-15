package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    private Person person1;
    private Person person2;
    @BeforeEach
    void setUp() {
        person1 = new Person(234566, "Ada Lovelace", 40, "mathematician ");
        person2 = new Person(223344, "Hedy Lamarr", 34, "inventor");
    };

    @Test
    @DisplayName("Throw error if age is less than zero")
    public void setAge_throwsExceptionWhenNegative() {
        assertThrows(IllegalArgumentException.class, () -> person1.setAge(-2));
    }


}
