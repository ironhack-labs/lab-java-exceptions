package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonsListTest {
    private PersonsList myList = new PersonsList();

    @BeforeEach
    public void setUp() {
        Person myPerson1 = new Person(1234, "John Hood", 34, "Policeman");
        Person myPerson2 = new Person(4536, "Anais Nin", 66, "writer");
        Person myPerson3 = new Person(7489, "Marry Kain", 54, "waiter");

        myList.addPerson(myPerson1);
        myList.addPerson(myPerson2);
        myList.addPerson(myPerson3);
    }

    @Test
    void findByName_CorrectNameFormat_Correct() {
        assertEquals(myList.getPersons().get(1), myList.findByName("Anais Nin"));
    }

    @Test
    void findByName_IncorrectNameFormat_Error() {
        assertThrows(CorrectName.class, () -> {
            myList.findByName("Anais");
        });
    }

    @Test
    void testClone_InstancePerson_Correct() {
        assertTrue(myList.getPersons().get(2).equals(new Person (7489,"Marry Kain", 54,"waiter")) &&
                myList.getPersons().get(2).getId()!=myList.clone(myList.getPersons().get(2)).getId());

    }
}