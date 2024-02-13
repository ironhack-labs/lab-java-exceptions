import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PersonTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetAge() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        person.setAge(-1);
    }
    @Test
    public void testFindByName() {
        PersonsList personsList = new PersonsList();
        Person johnDoe = new Person(1, "John Doe", 30, "Engineer");
        personsList.add(johnDoe);
        personsList.add(new Person(2, "Jane Doe", 25, "Doctor"));

        Person foundPerson = personsList.findByName("John Doe");

        assertEquals(foundPerson, johnDoe, "The found person should be John Doe");
    }

    @Test
    public void testClone() {
        PersonsList personsList = new PersonsList();
        Person johnDoe = new Person(1, "John Doe", 30, "Engineer");
        personsList.add(johnDoe);

        Person clonedPerson = personsList.clone(johnDoe);

        assertNotEquals(clonedPerson.getId(), johnDoe.getId(), "The id of the cloned person should be different");
        assertEquals(clonedPerson.getName(), johnDoe.getName(), "The name of the cloned person should be the same");
        assertEquals(clonedPerson.getAge(), johnDoe.getAge(), "The age of the cloned person should be the same");
        assertEquals(clonedPerson.getOccupation(), johnDoe.getOccupation(), "The occupation of the cloned person should be the same");
    }
}


