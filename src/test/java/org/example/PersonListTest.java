package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    PersonList myPersonList;
    Person sonia;


    PersonList setList(){
        Person pepe = new Person(1, "Pepe Perez", 30, "fontanero");
        sonia = new Person(2, "Sonia Lopez", 40, "sobrinisima");
        Person juan = new Person(4, "Pepe Perez", 30, "fontanero");
        Person john = new Person(5, "John Doe", 20, "student");
        List<Person> personList = new ArrayList<>();
        personList.add(pepe);
        personList.add(sonia);
        personList.add(juan);
        personList.add(john);
        return new PersonList(personList);

    }
    @BeforeEach
    void setUp(){
        myPersonList = setList();
    }


    @Test
    void findByName_Correct_Data(){
        Person obj = myPersonList.findByName("Sonia Lopez");
        assertEquals(sonia, obj);
    }

    @Test
    void findByName_Incorrect_Format(){
        assertThrows(IllegalArgumentException.class, ()->{
            myPersonList.findByName("SoniaLopez");
        });
    }

    @Test
    void clone_Test(){
        Person clon = myPersonList.clone(sonia);
        assertEquals(clon.getName(), sonia.getName());
        assertEquals(clon.getAge(), sonia.getAge());
        assertEquals(clon.getOccupation(), sonia.getOccupation());
        assertNotEquals(clon.getId(), sonia.getId());
    }

}