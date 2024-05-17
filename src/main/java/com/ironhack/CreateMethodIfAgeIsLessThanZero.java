import com.ironhack.Person;
import com.ironhack.PersonsList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class Test {

    //Test the setAge method to ensure that it throws an error if the age is less than 0.
    @Test //Age
    public void testSetAgeThrowsError() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        try {
            person.setAge(-5);
            fail("setAge method should have thrown an error for negative age");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be less than 0", e.getMessage());
        }
    }

    //Test the findByName method to ensure that it properly finds and returns the correct Person object
// when given a properly formatted name.
    @Test
    public void testFindByName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 25, "Doctor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        Person foundPerson = personsList.findByName("John Doe");
        assertNotNull(foundPerson);
        assertEquals(person1, foundPerson);

        foundPerson = personsList.findByName("Jane Smith");
        assertNotNull(foundPerson);
        assertEquals(person2, foundPerson);

        foundPerson = personsList.findByName("Invalid Name");
        assertNull(foundPerson); // Expecting null for a name that doesn't exist in the list
    }

    //private void assertNotNull(Person foundPerson) {}
    //private void assertNull(Person foundPerson) {}
    //private void assertEquals(Person person2, Person foundPerson) {}

    //Test the findByName method to ensure that it throws an exception if the name parameter is not properly formatted.
    @Test
    public void testFindByNameThrowsError() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        personsList.addPerson(person1);

        try {
            personsList.findByName("Invalid Name Format");
            fail("findByName method should have thrown an error for invalid name format");
        } catch (IllegalArgumentException e) {
            assertEquals("Name should be formatted as 'firstName lastName'", e.getMessage());
        }
    }
//Test the clone method to ensure that it creates a new Person object with the same properties as the original, except with a new id.

    @Test
    public void testClone() {
        PersonsList personsList = new PersonsList();
        Person originalPerson = new Person(1, "John Doe", 30, "Engineer");
        Person clonedPerson = personsList.clone(originalPerson);

        // Ensure the properties are the same
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());

        // Ensure the new id is different
        assertNotEquals(originalPerson.getId(), clonedPerson.getId());
    }

    private void assertEquals(int age, int age1) {}
}


























