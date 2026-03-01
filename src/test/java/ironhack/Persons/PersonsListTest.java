package ironhack.Persons;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    @Test
    void findByName_whenRightArgument_returnsCorrectPerson() {
        PersonsList list = new PersonsList();
        Person person = new Person(1, "Jane Doe", 30, "Doctor");

        list.persons.add(person);

        Person result = list.findByName("Jane Doe");

        assertEquals(person, result);
    }

    @Test
    void findByName_whenInvalidFormat_throwsException() {
        PersonsList list = new PersonsList();

        assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("Jane");
        });
    }

    @Test
    void clone_createsNewPersonWithDifferentId() {
        PersonsList list = new PersonsList();
        Person original = new Person(1, "Joao Doe", 39, "Teacher");

        Person cloned = list.clone(original, 2);

        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original, cloned);
    }
}