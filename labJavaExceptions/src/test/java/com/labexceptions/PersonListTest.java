package com.labexceptions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {

    PersonsList personsList = new PersonsList();

    @BeforeEach
    void setUp() {
        Person person2 = new Person(3, "Jorge Rotas", 33, "doctor");
        Person person3 = new Person(6, "Paco Perez", 33, "doctor");
        personsList.addPerson(person2);
        personsList.addPerson(person3);
    }

    @Test
    void findByNameTest(){
        Person findByName = PersonsList.findByName("Paco Perez");
        System.out.println("Found person - Name: " + findByName.getName() + ", Age: " + findByName.getAge() + ", Occupation: " + findByName.getOccupation());
        assertThrows(IllegalArgumentException.class, () -> PersonsList.findByName("InvalidName"));
    }

    @Test
    void cloneTest(){
        Person person4 = new Person(8, "Jaime Pleno", 63, "almost retired");
        Person clone = PersonsList.clone(person4);
        System.out.println("Clone ID number is: " + clone.getId() + " Name is: " + clone.getName() + " Age is: " +  clone.getAge() + " And works as a: " + clone.getOccupation());
        assertNotEquals(person4.getId(), clone.getId());
        assertEquals(person4.getName(), clone.getName());
        assertEquals(person4.getAge(), clone.getAge());
        assertEquals(person4.getOccupation(), clone.getOccupation());
    }



}
