import org.example.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    public void test_SetAge(){
        Person p=new Person(1,"Ulvi",19,"Student");

        assertThrows(IllegalArgumentException.class,()->{
            p.setAge(-20);
        });
    }
}
