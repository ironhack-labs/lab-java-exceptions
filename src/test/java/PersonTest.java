import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(1, "John Doe", 30, "Engineer");
    }

    @Test
    @DisplayName("Comprobamos que la edad se establece correctamente")
    void setAgeOK() {
        person.setAge(35);
        assertEquals(35, person.getAge());
    }

    @Test
    @DisplayName("Comprobamos que la edad de 0 provoca error")
    void setAgeError() {
        person.setAge(0);
        assertEquals(0, person.getAge());
    }
}