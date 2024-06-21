import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    @Test
    void findByName() {
        Person p = new Person(2, "dan", 7, "Construction");

        List<Person> pll = new ArrayList<>();
        pll.add(p);
        PersonsList pl = new PersonsList(pll);

        assertTrue(pl.findByName("dan").equals(p));
    }

    @Test
    void testClone() {
        Person p = new Person(2, "dan", 7, "Construction");
        List<Person> pll = new ArrayList<>();
        PersonsList pl = new PersonsList(pll);

        assertTrue(pl.clone(p).equals(p));

    }
}