import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeWithNegativeValue() {
        Person person = new Person("Developer", 25, "Jane", "Larson", 1);
        person.setAge(-1);
    }
}