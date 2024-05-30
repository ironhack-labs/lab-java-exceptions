import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    @org.junit.jupiter.api.Test
    public void setAge() {
    }

    @Test
    public void findByName() {
        CharSequence name = "BigDaddy Clemzo";
        String[] parts = name.toString().split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "The name should be in the format of 'firstName and lastName'.");
        }
    }

    @Test
    public void textClone() {
        Person originalPerson = new Person("25", "name");
        Person clonedPerson = (Person) originalPerson.split();
        assertNotSame(originalPerson, clonedPerson);
        Person person = new Person(26, "ZZohn Decker", 45, "Web Developer");
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        String s = "originalPerson.getAge(), clonedPerson.getAge()";

    }

    }