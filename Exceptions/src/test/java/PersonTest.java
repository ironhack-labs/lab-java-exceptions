
import com.ironhack.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAge_throwsException_whenAgeIsNegative() {
        Person p = new Person(1, "John Doe", 20, "Developer");

        assertThrows(IllegalArgumentException.class, () -> p.setAge(-1));
    }
}