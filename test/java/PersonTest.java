import com.example.Person;
import com.example.PersonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;
    private PersonList personList;

    @BeforeEach
    void SetUp(){
       person=new Person(1,"Yunis Sadiq",3,"Worker");
       personList=new PersonList();
       personList.add(person);
       personList.add(new Person(2, "John Doe", 30, "Doctor"));
    }
    @Test
    void testSetAgeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
        assertEquals("Age cannot be negative", exception.getMessage());
    }
    @Test
    void testFindByNameValid() {
        Person found = personList. findByName("John Doe");
        assertNotNull(found);
        assertEquals("John Doe", found.getName());
        assertEquals(30, found.getAge());
        assertEquals("Doctor", found.getOccupation());
    }

}
