import org.example.Person;
import org.example.PersonList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {
    @Test
    void testSetAge(){
        Person person = new Person(1,23,"Elcin Quluzade","Dev");
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
           person.setAge(-2);
        });
        assertEquals(("Age cannot be less than 0."), exception.getMessage());
    }

    @Test
    void testFindByNameReturnsCorrectPerson(){
        PersonList list = new PersonList();
        Person p1 = new Person(1,23,"Elcin Quluzade", "Dev");
        Person p2 = new Person(2,24,"Hesen Ilyas", "Dev");
        list.addPerson(p1);
        list.addPerson(p2);
        Person find = list.findByName("Elcin Quluzade");
        assertEquals(p1, find);
    }
    @Test
    void testFindByNameReturnInvalidFormat(){
        PersonList list = new PersonList();
        Person p1 = new Person(1,23,"Elcin Quluzade", "Dev");
        list.addPerson(p1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("Hesen");
        });
        assertEquals("Name format must be 'first name last name'", exception.getMessage());
    }
    @Test
    void testFindByNameNotFind(){
        PersonList list = new PersonList();
        Exception exception = assertThrows(RuntimeException.class, ()->{
            list.findByName("Hesen Ilyas");
        });
        assertEquals("this name is not find",exception.getMessage());
    }

    @Test
    void testCloneCreatesNewPersonWithSameProperties(){
        PersonList list = new PersonList();
        Person p1 = new Person(1,23,"Elcin Quluzade", "Dev");
        list.addPerson(p1);
        Person cloneP1 = list.clone(p1,4);
        assertNotEquals(p1.getId(),cloneP1.getId());
        assertEquals(p1.getAge(), cloneP1.getAge());
        assertEquals(p1.getName(), cloneP1.getName());
        assertEquals(p1.getOccupation(), cloneP1.getOccupation());
    }
}
