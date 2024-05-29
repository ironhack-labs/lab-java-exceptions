import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonTests {

    @Test
    public void testSetAgeNegative() {
        Person person = new Person(1, "Goku Son", 25, "Fighter");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5); // Test setting a negative age
        });
    }

    @Test
    public void testFindByNameSuccess() {
        PersonsList personsList = new PersonsList();
        Person p1 = new Person(1, "Goku Son", 25, "Fighter");
        Person p2 = new Person(2, "Vegeta Prince", 30, "Prince of Saiyans");
        personsList.addPerson(p1);
        personsList.addPerson(p2);

        Person foundPerson = personsList.findByName("Vegeta Prince");
        assertEquals(p2, foundPerson); // Test finding a person by name
    }

    @Test
    public void testFindByNameInvalidFormat() {
        PersonsList personsList = new PersonsList();
        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("VegetaPrince"); // Test finding with invalid name format
        });
    }

    @Test
    public void testClone() {
        PersonsList personsList = new PersonsList();
        Person p1 = new Person(1, "Goku Son", 25, "Fighter");
        personsList.addPerson(p1);

        Person clonedPerson = personsList.clone(p1);
        assertEquals(p1.getName(), clonedPerson.getName());
        assertEquals(p1.getAge(), clonedPerson.getAge());
        assertEquals(p1.getOccupation(), clonedPerson.getOccupation());
        assertNotEquals(p1.getId(), clonedPerson.getId()); // Test that the IDs are different
    }
}
