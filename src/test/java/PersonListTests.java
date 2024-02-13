import org.junit.Test;
import static org.junit.Assert.*;

public class PersonListTests {
    @Test
    public void testSetAgeMethod(){
        Person person = new Person(1, "Pepito Perez",30, "Engineer");
        try {
            person.setAge(-5);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be negative ", e.getMessage());
        }
    }
    @Test
    public void testFindByNameMethodWithProperFormat() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Pepito Perez", 30, "Ingeniero");
        Person person2 = new Person(1, "Paco Pecas", 20, "Gracioso");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        Person foundPerson = personsList.findByName("Pepito Perez");
      assertEquals(person1, foundPerson);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameMethodWithImproperFormat() {
        PersonsList personsList = new PersonsList();
        personsList.findByName("PepitoPerez");
    }
    @Test
        public void testCloneMethod() {
            Person originalPerson = new Person(1, "John Doe", 30, "Engineer");
            PersonsList personsList = new PersonsList();
            Person clonedPerson = personsList.clone(originalPerson);
            assertNotEquals(originalPerson.getId(),clonedPerson.getId());
            assertEquals(originalPerson.getAge(),clonedPerson.getAge());
            assertEquals(originalPerson.getName(), clonedPerson.getName());
            assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
        }


}

