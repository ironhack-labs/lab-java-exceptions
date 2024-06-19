import Ironhack.schl.Person;
import Ironhack.schl.PersonList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    public void testSetAge() throws IllegalArgumentException {
        // To verify that the method sets the age correctly.
        Person person = new Person(407809, "Rori Donovan", 35, "Engineer");
        assertEquals(35, person.getAge());
        // To verify that the method throws an exception when the age is negative.
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-36));

        // To verify that the method sets an updated age correctly.
        person.setAge(36);
        assertEquals(36, person.getAge());
    }
}
