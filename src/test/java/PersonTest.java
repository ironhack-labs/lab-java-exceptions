import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    @Test
    void setInvalidAge() {
        person = new Person(123, "Ana Rebelo", 5, "Engineer");
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-5));
    }
}