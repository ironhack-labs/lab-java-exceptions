
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void testSetAge() throws IllegalArgumentException {
       var person = new Person(1,"he", 1,"ho ho");
       assertThrows(IllegalArgumentException.class,() -> { person.setAge(0);});
    }
}