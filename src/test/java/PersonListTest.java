import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    PersonList listPerson = new PersonList();

    Person dummyPerson;

    @BeforeEach
    void setUp() {
        dummyPerson = new Person(2, "Arian Collaso", 32, "It");
        listPerson.addPerson(dummyPerson);
    }

    @Test
    void returnFoundPerson() {
        Person personFound =  listPerson.findByName(dummyPerson.getName());
        assertEquals(personFound, dummyPerson);
    }

    @Test
    void returnExceptionOnFindByName(){
        assertThrows(IllegalArgumentException.class, () -> listPerson.findByName("ArcoroCoar"));
    }

    @Test
    void returnPersonClonedExceptId() {
        Person cloned = listPerson.clone(dummyPerson);
        assertEquals(cloned.getAge(), dummyPerson.getAge());
        assertEquals(cloned.getName(),dummyPerson.getName());
        assertEquals(cloned.getOccupation(), dummyPerson.getOccupation());
        assertNotEquals(cloned.getId(), dummyPerson.getId());
    }
}