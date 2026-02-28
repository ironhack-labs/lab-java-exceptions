//PersonTest

import com.ironhack.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class PersonTest {

    @Test

    void testSetAgeThrowsException() {
        Person p = new Person(1, "John Doe", 25, "Developer");
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-5));
    }
}