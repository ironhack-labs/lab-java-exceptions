import org.junit.Test;
import static org.junit.Assert.*;

public class PersonsListTest {

    @Test
    public void testFindByName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 25, "Software Engineer");
        personsList.addPerson(person1);

        // Test finding a person by a properly formatted name
        assertEquals(person1, personsList.findByName("John Doe"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameInvalidFormat() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 25, "Software Engineer");
        personsList.addPerson(person1);

        // Test finding a person by an improperly formatted name
        personsList.findByName("John"); // This should throw an exception
    }

    @Test
    public void testClone() {
        Person originalPerson = new Person(1, "John Doe", 25, "Software Engineer");

        PersonsList personsList = new PersonsList();
        Person clonedPerson = personsList.clonePerson(originalPerson, 2);

        // Test if the cloned person has the same properties as the original except the id
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());

        // Test if the id of the cloned person is different from the original
        assertNotEquals(originalPerson.getId(), clonedPerson.getId());
    }
}
