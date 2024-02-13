import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person p;
    @BeforeEach
    public void initEach(){
        p = new Person(12345, "Antonio Ruiz", 33, "Developer");
    }

    @Test
    void setName() {
        assertThrows(IllegalArgumentException.class, () -> p.setName("firstName"));
    }

    @Test
    void setAge() {
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-1));
        assertEquals(33, p.getAge());
        p.setAge(22);
        assertEquals(22, p.getAge());
    }

    @Test
    void testEquals() {
        Person pClone = new Person(12345, "Antonio Ruiz", 33, "Developer");
        assertTrue(pClone.equals(p));
        pClone.setName("Juan Rubio");
        assertFalse(pClone.equals(p));
    }
}