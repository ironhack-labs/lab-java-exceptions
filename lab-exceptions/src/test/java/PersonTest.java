import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("It should gives an error if age is negative")
    void negativeAgeException() {
        Person person = new Person(1, "Juan Perez", 30, "Developer");

        assertThrows(IllegalArgumentException.class, () -> person.setAge(-5));
    }

    @Test
    @DisplayName("Gives an error if it doesn't return correct person ")
    void testFindByNameReturnsCorrectPerson() {
        PersonList personList = new PersonList();
        Person person = new Person(1, "María Ruiz", 25, "Actriz");
        personList.addPerson(person);

        Person foundPerson = personList.findByName("María Ruiz");
        assertNotNull(foundPerson);
        assertEquals("María Ruiz", foundPerson.getName());
    }

    @Test
    @DisplayName("Gives an error if format is not correct and exception is not thrown ")
    void testCorrectFormatException() {
        PersonList personList = new PersonList();
        personList.addPerson(new Person(1, "María Ruiz", 25, "Actriz"));

        assertThrows(IllegalArgumentException.class, () -> personList.findByName("MaríaRuiz"));
    }
}
