import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    @Test
    public void testFindByName() {
        PersonsList list = new PersonsList();
        Person person = new Person(1, "John Doe", 25, "Engineer");
        list.addPerson(person);

        assertEquals(person, list.findByName("John Doe"));
    }

    @Test
    public void testFindByNameInvalidFormat() {
        PersonsList list = new PersonsList();
        assertThrows(IllegalArgumentException.class, () -> list.findByName("JohnDoe"));
    }

    @Test
    public void testClone() {
        PersonsList list = new PersonsList();
        Person original = new Person(1, "John Doe", 25, "Engineer");
        Person clone = list.clone(original);

        assertNotEquals(original.getId(), clone.getId());
        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getAge(), clone.getAge());
        assertEquals(original.getOccupation(), clone.getOccupation());
    }
}
