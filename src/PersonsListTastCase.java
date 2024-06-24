import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonsListTestCase {

    private PersonsList personsList;
    private Person p1;
    private Person p2;

    @BeforeEach
    void setUp() {
        personsList = new PersonsList();
        p1 = new Person(1, "Javi", "Rice", 30);
        p2 = new Person(2, "Sam", "Jones", 25);
        personsList.addPerson(p1);
        personsList.addPerson(p2);
    }

    @Test
    void testSetAgeThrowsExceptionForNegativeAge() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            p1.setAge(-1);
        });
        assertEquals("Age cannot be negative", thrown.getMessage());
    }

    @Test
    void testFindByNameReturnsCorrectPerson() {
        Person foundPerson = personsList.findByName("Javi Rice");
        assertNotNull(foundPerson);
        assertEquals(p1, foundPerson);
    }

    @Test
    void testFindByNameThrowsExceptionForInvalidNameFormat() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("JohnDoe");
        });
        assertEquals("Name must be in the format 'firstName lastName'", thrown.getMessage());
    }

    @Test
    void testCloneCreatesNewPersonWithSamePropertiesAndNewId() {
        Person clonedPerson = personsList.clone(p1);
        assertNotNull(clonedPerson);
        assertEquals(p1.getFirstName(), clonedPerson.getFirstName());
        assertEquals(p1.getLastName(), clonedPerson.getLastName());
        assertEquals(p1.getEmail(), clonedPerson.getEmail());
        assertEquals(p1.getPhoneNumber(), clonedPerson.getPhoneNumber());
        assertEquals(p1.getAge(), clonedPerson.getAge());
        assertNotEquals(p1.getId(), clonedPerson.getId());
    }
}
