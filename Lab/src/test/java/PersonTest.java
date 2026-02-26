import org.example.Person;
import org.example.PersonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    Person person;
    PersonList personList=new PersonList();
    @BeforeEach
    void setUp(){
        person=new Person(1,"Albert Einstein",65,"Scientist");
        personList.addPerson(person);
    }
    @Test
    void setAge_negativeAge_throwsException(){
        assertThrows(IllegalArgumentException.class,()->person.setAge(-3));
    }
    @Test
    void findByName_findsAndReturnsCorrectPerson(){
        assertEquals(person,personList.findByName("Albert Einstein"));
    }
    @Test
    void findByName_IncorrectFormat_throwsException(){
        assertThrows(IllegalArgumentException.class,()->personList.findByName("AlbertEinstein"));
    }
    @Test
    void clone_createsCorrectPerson(){
        assertEquals(person,personList.clone(person));
    }
    @Test
    void clone_InvalidArg_throwsException(){
        assertThrows(NullPointerException.class,()->personList.clone(null));
    }
}
