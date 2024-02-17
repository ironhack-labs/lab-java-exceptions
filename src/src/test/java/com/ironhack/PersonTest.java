package com.ironhack;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    private Person person;

    @Before
    public void createData() {
        person = new Person(1, "Jane Doe", 18, "Developer");
    }

    @Test
    public void setAge_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }


}
