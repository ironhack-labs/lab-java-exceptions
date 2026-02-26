import org.example.Person;
import org.example.PersonsList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {

    @Test
    void findByNameReturnCorrectPerson(){
        PersonsList list=new PersonsList();
        Person person1=new Person(1,"yaqut rslbyl",20, "developer");
        Person person2=new Person(2,"yaqut rslbyl",20, "developer");
        Person person3=new Person(3,"konul rasullu",14, "pilot");
list.addPerson(person1);
        list.addPerson(person2);
        list.addPerson(person3);
Person result= list.findbyName("yaqut rslbyl");

assertNotNull(result);
assertEquals("yaqut rslbyl", person1.getName());
assertEquals(20, person1.getAge());
    }

    @Test
    void findByNameThrowsExceptionWhenNameFormatIsNotCorrect(){
        PersonsList list=new PersonsList();
        assertThrows(IllegalArgumentException.class, () ->{
            list.findbyName("Yaqut");

        });

}
    @Test
    void testCloneCreatesNewPersonWithNewId() {

        PersonsList list = new PersonsList();
        Person original=new Person(1,"yaqut rslbyl",20, "developer");
        Person cloned = list.clone(original);


        assertNotEquals(original.getId(), cloned.getId());


        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
    }

}

