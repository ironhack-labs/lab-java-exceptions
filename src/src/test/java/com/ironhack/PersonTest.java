package com.ironhack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void createData() {
        person = new Person(1, "Jane Doe", 18, "Developer");
    }

    @Test
    public void setAge_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }


}
