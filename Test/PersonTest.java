import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    void testSetAgeThrowsErrorWhenAgeIsNegative() {
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-5));
    }

    @Test
    void testSetNameIllegalFormatIncludeNumbers() {
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        assertThrows(IllegalArgumentException.class, () -> person.setName("C323"));
    }

    @Test
    void testSetNameIllegalFormatIncludeSpecialCharacters() {
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        assertThrows(IllegalArgumentException.class, () -> person.setName("Di€go Martins"));
    }

    @Test
    void testSetNameIllegalFormatNotIncludeSpace() {
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        assertThrows(IllegalArgumentException.class, () -> person.setName("DiegoMartins"));
    }

    @Test
    void testEqualsPerson() {
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        Person person2 = new Person(2, "Diego Martins", 34, "DeveloperInProgress");
        assertTrue(person.equals(person2));
    }

    @Test
    void testNonEqualsPerson() {
        Person person = new Person(1, "Diego Martins", 34, "DeveloperInProgress");
        Person person2 = new Person(2, "Diego Camacho", 34, "Accountant");
        assertFalse(person.equals(person2));
    }


}

