package ironhack.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person(1, "John akiwanski", 0, "IT");

    }

    @Test
    void setAge_ShouldThrowException_WhenAgeIsNegative() {

        assertThrows(IllegalArgumentException.class, () -> person.setAge(0));
    }
}

class PersonListTest {

        private PersonsList pl;

    @BeforeEach
    void setup(){
        pl = new PersonsList();
        pl.addPerson(new Person(1, "Abraka Song", 34, "HR" ));
        pl.addPerson(new Person(2, "Sheela Forth", 38, "DCM" ));
    }

        @Test
    void findByName_ShouldReturnCorrectPerson_WhenNameIsCorrectAndCaseInsensitive() {
        String test1 = "Abraka Song";

        Person foundPerson = pl.findByName(test1);
        assertEquals("Abraka Song", foundPerson.getName());
//        assertEquals(1, foundPerson.getId());
//        assertEquals(34, foundPerson.getAge());
    }
}


