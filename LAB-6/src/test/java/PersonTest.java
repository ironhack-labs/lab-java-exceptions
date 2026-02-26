import org.example.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
void setAgeThrowsExceptionIfIsNegative(){
        Person person=new Person(1,"Konul RSL",20, "developer");
        assertThrows(IllegalArgumentException.class, () ->{
            person.setAge(-10);

        });
    }
}
