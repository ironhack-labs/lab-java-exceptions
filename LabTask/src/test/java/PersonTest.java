import org.example.InvalidNameFormatException;
import org.example.Person;
import org.example.PersonsList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void setAge_shouldThrow_whenAgeLessThanZero() {
        Person p = new Person(1, "John Doe", 20, "Developer");
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-1));
    }

    @Test
    void findByName_shouldReturnCorrectPerson_whenNameIsProperlyFormatted() {
        Person p1 = new Person(1, "John Doe", 20, "Developer");
        Person p2 = new Person(2, "Jane Smith", 30, "Designer");
        PersonsList list = new PersonsList(List.of(p1, p2));

        Person found = list.findByName("Jane Smith");
        assertNotNull(found);
        assertEquals(p2, found);
        assertEquals(2, found.getId());
    }

    @Test
    void findByName_shouldThrow_whenNameIsNotProperlyFormatted() {
        PersonsList list = new PersonsList();
        assertThrows(InvalidNameFormatException.class, () -> list.findByName("Jane"));
        assertThrows(InvalidNameFormatException.class, () -> list.findByName("Jane  Smith"));
        assertThrows(InvalidNameFormatException.class, () -> list.findByName(" Jane Smith"));
        assertThrows(InvalidNameFormatException.class, () -> list.findByName("Jane Smith "));
    }

    @Test
    void clone_shouldCreateNewPerson_withSamePropertiesExceptNewId() {
        Person original = new Person(10, "John Doe", 25, "Developer");
        PersonsList list = new PersonsList(List.of(original));

        Person cloned = list.clone(original);

        assertNotNull(cloned);
        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
        assertTrue(original.equals(cloned));
    }
}
