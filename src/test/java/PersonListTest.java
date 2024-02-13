import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    Person person;
    List<Person> list = new ArrayList<>();
    PersonList personList;

    @BeforeEach
    void setUp() {
        person = new Person(123, "Ana Rebelo", 5, "Engineer");
        list.add(person);
        personList = new PersonList(list);
    }

    @Test
    void findByName() {
        assertEquals(person, personList.findByName(person.getName()));
        assertNull(personList.findByName("Not Existent"));
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("Ana"));
    }

    @Test
    void testClone() {
        Person clone = personList.clone(person);
        assertEquals(person, clone);
        assertNotEquals(person.getId(), clone.getId());
    }
}