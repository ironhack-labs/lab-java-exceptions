import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testSetAge() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

    @Test
    public void testEquals() {
        Person person1 = new Person(1, "John Doe", 25, "Engineer");
        Person person2 = new Person(2, "John Doe", 25, "Engineer");
        assertTrue(person1.equals(person2));
    }
}
