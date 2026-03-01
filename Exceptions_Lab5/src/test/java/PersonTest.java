import com.ironhack.Person;
import com.ironhack.PersonList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testSetAgeThrowsErrorForNegative() {
        Person person = new Person(1, "Thor Qasimov", 45, "Tanri of Mjolnir");

        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }

    // Test2: findByName
    @Test
    public void testFindByNameWorksCorrectly() {
        PersonList list = new PersonList();
        Person p1 = new Person(1, "Hulk Xelilov", 30, "Doctor");
        list.addPerson(p1);

        Person result = list.findByName("Hulk Xelilov");
        assertNotNull(result);
        assertEquals("Hulk Xelilov", result.getName());
    }

    // Test 3: findByName whitespace ile yazanda exception eleyir
    @Test
    public void testFindByNameThrowsExceptionForWrongFormat() {
        PersonList list = new PersonList();

        assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("SingleName");
        });
    }

    @Test
    public void testCloneCreatesNewObjectWithDifferentId() {
        PersonList list = new PersonList();
        Person original = new Person(10, "Sarah Smith", 28, "Engineer");

        Person cloned = list.clone(original);

        assertNotEquals(original.getId(), cloned.getId()); // idleri FERQLI (NOT equals) olmasini yoxlayir
        assertEquals(original.getName(), cloned.getName()); // adin,
        assertEquals(original.getAge(), cloned.getAge());   // agelerin muqayise edir eyni olsun
    }
}
