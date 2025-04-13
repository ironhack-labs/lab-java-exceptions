import org.example.Person;
import org.example.PersonsList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;

public class PersonListsTest {

    private Person person;
    private PersonsList personsList;

    @BeforeEach
    public void setUp() {
        person = new Person(Person.NEXT_ID++, "John Doe", 30, "Engineer");
        personsList = new PersonsList();
        personsList.addPerson(new Person(1, "John Doe", 30, "Engineer"));
        personsList.addPerson(new Person(2, "Jane Smith", 25, "Designer"));
    }

    @Test
    public void testSetAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
    }

    @Test
    public void testFindByName() {
        Person foundPerson = personsList.findByName("John Doe");
        assertEquals("John Doe", foundPerson.getName());
    }

    @Test
    public void testFindByNameInvalidFormat() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("John");
        });
    }

    @Test
    public void testClone() {
        Person cloned = personsList.clone(person);
        assertNotEquals(person.getId(), cloned.getId());
        assertEquals(person.getName(), cloned.getName());
        assertEquals(person.getAge(), cloned.getAge());
        assertEquals(person.getOccupation(), cloned.getOccupation());
    }







}
