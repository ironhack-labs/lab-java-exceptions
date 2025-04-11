import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {

    PersonList personList;
    List<Person> testList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        testList.add(new Person(1, "John Doe", 30, "Engineer"));
        testList.add(new Person(2, "Jane Smith", 25, "Designer"));
        personList = new PersonList(testList);
    }

    @Test
    @DisplayName("Comprobamos que la lista de personas no es nula")
    void getPersonsOK() {
        List<Person> persons = personList.getPersons();
        assertEquals(testList.size(), persons.size());
        assertEquals(testList.get(0).getName(), persons.get(0).getName());
        assertEquals(testList.get(1).getName(), persons.get(1).getName());
    }


    @Test
    @DisplayName("Comprobamos que la lista de personas contiene un nombre válido")
    void findByNameValid() {
        Person person = personList.findByName("John Doe");
        assertNotNull(person);
        assertEquals("John Doe", person.getName());
    }

    @Test
    @DisplayName("Comprobamos que la lista de personas contiene un nombre inválido")
    void findByNameInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("JohnDoe"));
    }

    @Test
    @DisplayName("Comprobamos que se clona correctamente un objeto Person")
    void testCloneOK() {
        Person test = testList.getFirst();
        Person cloned = personList.clone(test);

        assertNotNull(cloned);
        assertNotEquals(test.getId(), cloned.getId());
        assertEquals( test.getName(), cloned.getName());
        assertEquals(test.getAge(), cloned.getAge());
        assertEquals(test.getOccupation(), cloned.getOccupation());
    }


}