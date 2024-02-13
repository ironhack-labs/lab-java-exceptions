import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    private Person p1;
    private Person p2;
    private PersonsList personsList = new PersonsList();;

    @BeforeEach
    public void initEach(){
        p1 = new Person(12345, "Antonio Ruiz", 33, "Developer");
        p2 = new Person(54321, "Juan Rubio", 30, "Designer");
        personsList.addPerson(p1);
        personsList.addPerson(p2);
    }

    @Test
    void findByName() {
        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("hello"));
        assertEquals(p2, personsList.findByName("Juan Rubio"));
    }

    @Test
    void testClone() {
        Person p1Clone = personsList.clone(p1);
        assertNotEquals(p1Clone.getId(), p1.getId());
        assertEquals(p1Clone.getName(), p1.getName());
        assertEquals(p1Clone.getAge(), p1.getAge());
        assertEquals(p1Clone.getOccupation(), p1.getOccupation());
    }
}