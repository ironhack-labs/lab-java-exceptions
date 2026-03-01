package ironhack.Persons;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void setAge_whenNegative_ThrowsException() {
        Person person = new Person(1, "John Doe", 20, "Engineer");

        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }
}