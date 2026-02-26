import com.ironhack.Person;
import com.ironhack.PersonsList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testSetAgeThrowsException() {
        Person person = new Person(1, "Test Name", 25, "Engineer");

        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }

    @Test
    void testFindByNameSuccess() {
        PersonsList list = new PersonsList();
        Person person = new Person(1, "Test Name", 30, "Doctor");
        list.addPerson(person);

        Person found = list.findByName("Test Name");

        assertEquals(person, found);
    }

    @Test
    void testFindByNameInvalidFormat() {
        PersonsList list = new PersonsList();

        assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("TestName");
        });
    }

    @Test
    void testCloneCreatesNewPersonWithDifferentId() {
        PersonsList list = new PersonsList();
        Person original = new Person(1, "Test Name", 28, "Lawyer");

        Person cloned = list.clone(original);

        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
    }
}
