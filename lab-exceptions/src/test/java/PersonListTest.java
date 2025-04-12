import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    @Test
    @DisplayName("Gives an error if cloned person doesn`t have same properties")
    void testCloneCreatesNewPerson() {
        PersonList personList = new PersonList();
        Person person = new Person(1, "Carlos Gomez", 40, "Abogado");
        personList.addPerson(person);

        Person clonedPerson = personList.clone(person);

        assertNotEquals(person.getId(), clonedPerson.getId());
        assertEquals(person.getName(), clonedPerson.getName());
        assertEquals(person.getAge(), clonedPerson.getAge());
        assertEquals(person.getOccupation(), clonedPerson.getOccupation());
    }
}
