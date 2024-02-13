package pack;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    @Test
    public void testSetAgeThrowsError() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }

    @Test
    public void testFindByNameProperlyFormattedName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Doe", 25, "Doctor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        assertEquals(person1, personsList.findByName("John Doe"));
    }

    @Test
    public void testFindByNameThrowsException() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "John Doe", 30, "Engineer");
        personsList.addPerson(person);

        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("John");
        });
    }

    @Test
    public void testCloneCreatesCloneObject() {
        Person originalPerson = new Person(1, "John Doe", 30, "Engineer");
        PersonsList personsList = new PersonsList();
        Person clonedPerson = personsList.clone(originalPerson);

        assertNotEquals(originalPerson.getId(), clonedPerson.getId());

        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
    }
}