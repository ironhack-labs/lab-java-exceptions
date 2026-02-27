import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import az.testexceptions.Person;
import az.testexceptions.PersonList;

public class PersonTest {


    //Test the setAge method to ensure that it throws an error if the age is less than 0.
    private Person person;
    private PersonList personList;

    @Test
    void ageIsIllegalValue(){
        person = new Person(1, "John Doe", 30, "Engineer");
        assertThrows(IllegalArgumentException.class,
            () -> person.setAge(-5));
    }


    //Test the findByName method to ensure that it properly finds and returns the correct 
    // Person object when given a properly formatted name.
    @Test
    void nameIsIllegalValue(){
        person = new Person(1, "John Doe", 30, "Engineer");
        PersonList personList = new PersonList();
        assertThrows(IllegalArgumentException.class,
            () -> personList.findByName("John"));
    }

    //Test the findByName method to ensure that it throws an exception if the name
    //parameter is not properly formatted.

    @Test
    void isNameAcceptable(){
        person = new Person(1, "John Doe", 30, "Engineer");
        PersonList personList = new PersonList();

        assertThrows(IllegalArgumentException.class,
            () -> personList.findByName("JohnDoe"));
    }


    //Test the clone method to ensure that it creates a new Person object with 
    // the same properties as the original, except with a new id.


    //problematic method btw need explanation
@Test
    void clone_returnsCorrectPerson_exceptId() {

        Person person = new Person(1, "Sevinj Guliyeva", 19, "translator");
        Person clonedPerson = personList.clone(person);

        assertNotNull(clonedPerson);
        assertNotEquals(person.getId(), clonedPerson.getId());
        assertEquals("Sevinj Guliyeva", clonedPerson.getName());
        assertEquals(19, clonedPerson.getAge());
        assertEquals("translator", clonedPerson.getOccupation());
    }





}

