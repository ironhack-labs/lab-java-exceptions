import Ironhack.schl.Person;
import Ironhack.schl.PersonList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {
    @Test
    public void testFindByName() throws IllegalArgumentException {

        Person person1 = new Person(407809, "Rori Donovan", 35, "Engineer");
        PersonList personList1 = new PersonList(List.of(person1));
        // To verify that the method returns the correct person when the name is found.
        assertEquals(person1, personList1.findByName("Rori Donovan"));
    }
    @Test
    public void testFindByName_ImproperFormatting() throws IllegalArgumentException {

        Person person2 = new Person(407809, "DeidreLlewellyn", 55, "Physicist");
        PersonList personList2 = new PersonList(List.of(person2));
        // To verify that the method throws an exception when the name is not found.
        assertThrows(IllegalArgumentException.class, () -> personList2.findByName("Deidre Llewellyn"));
    }
    @Test
    public void testClone() throws IllegalArgumentException {

        Person person1 = new Person(407809, "Rori Donovan", 35, "Engineer");
        PersonList personList1 = new PersonList(List.of(person1));
        //To verify that the method clones the person's name, age, and occupation correctly.
        // The id should differ from the original person.
        Person person3 = personList1.clone(person1);
        assertEquals(person1.getName(), person3.getName());
        assertEquals(person1.getAge(), person3.getAge());
        assertEquals(person1.getOccupation(), person3.getOccupation());
        assertNotEquals(person1.getId(), person3.getId());
    }

}
