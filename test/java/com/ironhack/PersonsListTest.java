package com.ironhack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {



    @Test
     void testFindByNameReturnsCorrectPerson() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1,"Peter Cole",60,"Farmer");
        personsList.addPerson(person);

        Person foundPerson = personsList.findByName("Peter Cole");
        assertEquals(person, foundPerson);
    }

    @Test
    void testFindByNameThrowsExceptionForImproperlyFormattedName(){
        PersonsList personsList = new PersonsList();
        assertThrows(IllegalArgumentException.class,() -> personsList.findByName("Peter"));
    }

    @Test
    void testCloneCreatesNewPersonWithNewId(){
        Person originalPerson = new Person(1,"Peter Cole", 60, "Farmer");
        PersonsList personsList = new PersonsList();
        Person clonedPerson = personsList.clone(originalPerson);

        assertNotEquals(originalPerson.getId(), clonedPerson.getId());
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());

    }

}