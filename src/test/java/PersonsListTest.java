import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonsListTest {
    private PersonsList personsList;
    private Person person1;
    private Person person2;

    @Before
    public void setUp() {
        personsList = new PersonsList();
        person1 = new Person("Teacher", 30, "Michael", "Prowse", 1);
        person2 = new Person("Engineer", 40, "Marqiue", "Daniel", 2);

        personsList.personsList.add(person1);
        personsList.personsList.add(person2);
    }

    @Test
    public void testFindByNameSuccess() {
        Person result = personsList.findByName("Marqiue Daniel");
        assertNotNull(result);
        assertEquals(person2, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameImproperFormat() {
        personsList.findByName("MarqiueDaniel");
    }

    @Test
    public void testClonePerson() {
        Person clonedPerson = personsList.clone(person1);
        assertNotNull(clonedPerson);
        assertEquals(person1.getName(), clonedPerson.getName());
        assertEquals(person1.getAge(), clonedPerson.getAge());
        assertEquals(person1.getOccupation(), clonedPerson.getOccupation());
        assertNotEquals(person1.getId(), clonedPerson.getId());
    }
}