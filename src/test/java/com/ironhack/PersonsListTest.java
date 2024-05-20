package com.ironhack;

import com.ironhack.Person;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
    @Test
    public void given_Name_() {
        Faker f = new Faker();
        PersonsList personList = new PersonsList();
        Person p1 = new Person(1, "John Doe",33,f.job().position());
        Person p2 = new Person(2, f.name().fullName(), 25, f.job().position());

        assertNull(personList.findByName("John Doe"));




    }

    @Test
    public void testCloneCreatesCloneObject() {
        Person originalPerson = new Person(1, "John Doe", 30, "Engineer");
        PersonsList personsList = new PersonsList();
        Person clonedPerson = personsList.clone(originalPerson, 5);
        assertNotEquals(originalPerson.getId(), clonedPerson.getId());
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
    }


}