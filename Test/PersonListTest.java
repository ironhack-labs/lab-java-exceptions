import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {


    @Test
    void testFindByNameHappyPath() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        Person person2 = new Person(2, "Diego Camacho", 34, "Accountant");
        personsList.addPerson(person);
        personsList.addPerson(person2);

        assertEquals(person, personsList.findByName("Diego Martins"));
        assertEquals(person2, personsList.findByName("Diego Camacho"));
    }

    @Test
    void testFindByNamePersonNotIncludeInTheList() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        personsList.addPerson(person);

        assertNull(personsList.findByName("Diego Camacho"));
    }

    @Test
    void testClonePerson(){
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        personsList.addPerson(person);
        personsList.addPerson(personsList.clone(person));

        assertTrue(personsList.getPersonList().get(0).equals(personsList.getPersonList().get(1)));

    }

    @Test
    void testFindByNameThrowsExceptionForImproperlyFormattedName() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        personsList.addPerson(person);

        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("Di€go Martins")); // Missing space
        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("DiegoMartins")); // Extra space
    }

}
