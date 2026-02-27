
import com.ironhack.Person;
import com.ironhack.PersonsList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    @Test
    void findByName_returnsCorrectPerson_whenNameIsProperlyFormatted() {
        PersonsList list = new PersonsList();
        Person p1 = new Person(1, "John Doe", 25, "Developer");
        Person p2 = new Person(2, "Jane Smith", 30, "Teacher");

        list.addPerson(p1);
        list.addPerson(p2);

        Person found = list.findByName("Jane Smith");

        assertNotNull(found);
        assertEquals(p2, found);
    }

    @Test
    void findByName_throwsException_whenNameIsNotProperlyFormatted() {
        PersonsList list = new PersonsList();

        assertThrows(IllegalArgumentException.class, () -> list.findByName("John")); // 1 söz
        assertThrows(IllegalArgumentException.class, () -> list.findByName("John Michael Doe")); // 3 söz
        assertThrows(IllegalArgumentException.class, () -> list.findByName("")); // boş
        assertThrows(IllegalArgumentException.class, () -> list.findByName(null)); // null
    }

    @Test
    void clone_createsNewPerson_withSamePropertiesExceptNewId() {
        PersonsList list = new PersonsList();
        Person original = new Person(10, "John Doe", 25, "Developer");

        Person copy = list.clone(original);

        assertNotNull(copy);
        assertNotSame(original, copy);

        assertNotEquals(original.getId(), copy.getId()); // yeni id
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());
        assertEquals(original.getOccupation(), copy.getOccupation());

        assertEquals(original, copy);
    }
}