import org.example.Person;
import org.example.PersonList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    @Test
    public void test_FindByName_ProperlyFomatted(){
        Person person =new Person(1,"Ulvi Haciyev",19,"Student");
        PersonList personList=new PersonList(List.of(person));

        assertEquals("Ulvi Haciyev",personList.findByName("Ulvi Haciyev").getName());
    }
    @Test
    public void test_FindByName_ThrowsException_NoProperlyName(){
        Person person =new Person(1,"Ulvi Haciyev",19,"Student");
        PersonList personList=new PersonList(List.of(person));

        assertThrows(IllegalArgumentException.class,()->{
            personList.findByName("Ulvi ");
        });
    }
    @Test
    public void test_CloneCreates_NewPerson_WithNewId(){
        Person person =new Person(1,"Ulvi Haciyev",19,"Student");
        PersonList personList=new PersonList(List.of(person));
        Person newPerson=personList.clone(person);


        assertNotEquals(newPerson.getId(),person.getId());
        assertEquals(newPerson.getName(),person.getName());
        assertEquals(newPerson.getAge(),person.getAge());
        assertEquals(newPerson.getOccupation(),person.getOccupation());
    }
}
