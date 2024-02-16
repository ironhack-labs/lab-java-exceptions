package com.labexceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PersonTestTest {



    @BeforeEach
    void setUp() {
        Person person;

    }

    @Test
    void negative_age(){
        Person person = new Person(1, "John Doe", 6, "Engineer");
    }
}