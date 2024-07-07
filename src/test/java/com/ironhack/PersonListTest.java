package com.ironhack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {

    @Test
    void findByName_ReturnsCorrectObject() {
        // Arrange
        Person samplePerson = new Person(1, "firstname lastname", 99, "occupation");
        PersonList samplePersonList = new PersonList();
        samplePersonList.addPerson(samplePerson);
        // Assert
        assertEquals(samplePerson, samplePersonList.findByName("firstname lastname"));
    }

    @Test
    void findByName_ThrowsException() {
        // Arrange
        PersonList samplePersonList = new PersonList();
        // Assert
        assertThrows(IllegalArgumentException.class, () -> samplePersonList.findByName("firstname"));
    }

    @Test
    void Clone() {
        // Arrange
        Person samplePerson = new Person(1, "firstname lastname", 99, "occupation");
        PersonList samplePersonList = new PersonList();
        samplePersonList.addPerson(samplePerson);
        // Act
        Person clonedPerson = samplePersonList.clone(samplePerson, 2);
        // Assert
        assertEquals(samplePerson, clonedPerson);
        assertNotEquals(samplePerson.getId(), clonedPerson.getId());
    }

}