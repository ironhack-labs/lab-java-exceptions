import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person dummyPerson;

    @BeforeEach
    void setUp() {
        dummyPerson = new Person(234, "Dummy, Person", 18, "IT");
    }

    @Test
    @DisplayName("Return an IllegalArgument Exception if age es lower than 0")
    void setAge() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> dummyPerson.setAge(-1));
        assertEquals(e.getMessage(), "Age cannot be negative");
    }
}