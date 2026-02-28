//PersonListTest
import com.ironhack.Person;
import com.ironhack.PersonList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {
    @Test
    void testFindByName() throws Exception {
        PersonList list = new PersonList();
        Person p = new Person(1, "Jane Doe", 30, "Designer");
        list.addPerson(p);

        assertEquals(p, list.findByName("Jane Doe"));
        assertThrows(Exception.class, () -> list.findByName("Jane")); // bad format
    }

    @Test
    void testClonePerson() {
        Person original = new Person(1, "John Smith", 40, "Engineer");
        PersonList list = new PersonList();
        Person clone = list.clonePerson(original, 2);

        assertEquals(original.getFullName(), clone.getFullName());
        assertEquals(original.getAge(), clone.getAge());
        assertEquals(original.getOccupation(), clone.getOccupation());
        assertNotEquals(original.getId(), clone.getId()); // new id
    }
}