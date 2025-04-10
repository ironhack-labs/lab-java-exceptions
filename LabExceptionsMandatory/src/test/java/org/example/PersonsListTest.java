package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    PersonsList personsList;
    //Person person = new Person(1, "Pedro Sanchez", 27,
          //  "Presidente del Gobierno");


    @BeforeEach
    void setUpPersonsList() {
        personsList= new PersonsList();

    }

    @Test
    @DisplayName("To ensure that it properly finds" +
            " and returns the correct Person object" +
            " when given a properly formatted name")

    void findByName() {
        Person personExist= personsList.findByName("Hugo Sanchez");
        assert "Hugo Sanchez".equalsIgnoreCase(personExist.getName());

        // Here must be throw exception
        assertThrows(IllegalArgumentException.class,
                ()->personsList.findByName("NombreApellidoSinEspacios"));
    }

    @Test
    @DisplayName ("To ensure that it creates a new Person object with the same" +
                    " properties as the original, except with a new id")

    void testClone() {
        Person person = personsList.getPersonList("Diego Suarez");
        Person clonedPerson= personsList.clone(person);
        assert person.equals(clonedPerson);

        clonedPerson.setAge(45);
        assert !(person.equals(clonedPerson));

    }
}