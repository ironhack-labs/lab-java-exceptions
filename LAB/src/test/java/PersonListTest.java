import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class PersonListTest{
    private Person person;
    private PersonList personList;
    @BeforeEach
    void setUp(){
        person = new Person(1234,"Ruzi Xancanov",20,"Student");
        personList = new PersonList();
        personList.addPerson(person);
    }

    @Test
    public void testFindByName_ReturnsCorrectPerson(){
        Person foundPerson = personList.findByName("Ruzi Xancanov");
        assertNotNull(foundPerson);
        assertEquals(person.getName(), foundPerson.getName());
        assertEquals(person.getAge(), foundPerson.getAge());
        assertEquals(person.getOccupation(), foundPerson.getOccupation());
        assertEquals(person.getId(), foundPerson.getId());
    }
    @Test
    public void testFindByName_ThrowsExceptionForSingleName(){
        assertThrows(IllegalArgumentException.class, ()->{
            personList.findByName("");
        });
    }
    @Test
    public void testClone_CreatesNewPersonWithDifferentId(){
        Person clonedPerson = personList.clone(person);
        assertNotNull(clonedPerson);
        assertNotEquals(person.getId(), clonedPerson.getId());
        assertEquals(person.getName(), clonedPerson.getName());
        assertEquals(person.getAge(), clonedPerson.getAge());
        assertEquals(person.getOccupation(), clonedPerson.getOccupation());
    }

}
