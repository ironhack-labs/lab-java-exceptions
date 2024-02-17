package org.lab204;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PersonTest {

    private Person person = new Person(2, "Julia Olle", 34, "developer");
    PersonList personList = new PersonList();

    //Test to set age when it is less than 0.
    @Test
    public void setNegativeAge(){
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

    //Test findbyname method to ensure that works properly.
    @Test
    public void findByNameProperFunctionality(){
        personList.getListPerson().add(person);
        personList.getListPerson().add(new Person(2,"Pepe Navarro", 45, "Firefighter"));

        assertEquals(personList.findByName("Julia Olle").getName(), "Julia Olle");
    }

    //Test findByName method with not correct name Format
    @Test
    public void findByNameProperFormat(){
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("Julia"));
    }

    //Test clone method
    @Test
    public void cloneTest(){
        Person person2 = personList.clone(person);

        assertEquals(person.getName(), person2.getName());
        assertEquals(person.getAge(), person2.getAge());
        assertEquals(person.getOccupation(), person2.getOccupation());
    }

}


