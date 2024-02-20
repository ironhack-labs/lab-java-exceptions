package classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
    Person persona = new Person(1,"Xavi",12,"QA engineer");
    Person persona2 = new Person(1,"Xavi Tirado",12,"QA engineer");
    Person[] lista = {persona,persona2};
    PersonsList listadopersonas = new PersonsList(lista);

    @Test
    void classFindsName() {
        assertEquals("Xavi Tirado",listadopersonas.findByName("Xavi Tirado").getName());
    }

    @Test
    void findByNameThrowsException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            listadopersonas.findByName("Xavi");;
        });
        String expectedMessage = "El nombre tiene un formato incorrecto";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void personIsCloned() {
        Person clonedPerson =listadopersonas.clone(persona);
        assertEquals(persona.getName(),clonedPerson.getName());
        assertEquals(persona.getAge(),clonedPerson.getAge());
        assertEquals(persona.getOccupation(),clonedPerson.getOccupation());
        assertNotEquals(persona.getId(),clonedPerson.getId());
    }
}