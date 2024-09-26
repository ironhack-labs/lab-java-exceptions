import org.junit.Test;
import static org.junit.Assert.*;
public class PersonTest {
    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeThrowTest(){
        Person person = new Person(1, "John Doe", 30, "Software Engineer");
        person.setAge(-1);
    }

    @Test
    public void testSetAgeTest(){
        Person person = new Person(1, "John Doe", 30, "Software Engineer");
        person.setAge(31);
        assertEquals(31, person.getAge());
    }

}
