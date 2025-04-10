import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PersonListTest {



    @Test
    void findByName_with_correct_format() {
        assertThrows(IllegalArgumentException.class,()-> PersonList.findByName(
                "Ana"));
    }

    @Test
    void testClone_Other_Person() {
        Person p2=new Person(2,"Abelardo Gomez",54,"Chatarrero");
        Person cloned=PersonList.clone(p2);

        assertEquals(p2.getName(),cloned.getName());
        assertEquals(p2.getAge(),cloned.getAge());
        assertEquals(p2.getOccupation(),cloned.getOccupation());

    }
}