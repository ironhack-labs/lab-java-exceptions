package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {
    @Test
    void setAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person persona = new Person(1,"Xavi",-12,"QA engineer");
        });
        String expectedMessage = "La edad es incorrecta, no puede ser menor que 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}