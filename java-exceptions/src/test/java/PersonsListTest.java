import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class PersonsListTest {

    @Test
    void testFindByNameReturnsCorrectPerson() {
        ArrayList<Person> people = new ArrayList<>();
        Person p1 = new Person(1, "Ingeniero", 30, "Juan Perez");
        Person p2 = new Person(2, "Doctora", 25, "Anita Ani");
        people.add(p1);
        people.add(p2);

        PersonsList personsList = new PersonsList(people);
        assertEquals(p1,personsList.findByName("Juan Perez"));
    }

    @Test
    void testFindByNameThrowsException() {
        ArrayList<Person> people = new ArrayList<>();
        Person p1 = new Person(1, "Ingeniero", 30, "Juan Perez");
        Person p2 = new Person(2, "Doctora", 25, "Anita Ani");
        people.add(p1);
        people.add(p2);

        PersonsList personsList = new PersonsList(people);
        assertThrows(IllegalArgumentException.class, () -> {personsList.findByName("Juan");});
    }


    @Test
    void testCloneCreatesSamePerson() {
        ArrayList<Person> people = new ArrayList<>();
        Person p1 = new Person(1, "Ingeniero", 30, "Juan Perez");
        Person p2 = new Person(2, "Doctora", 25, "Anita Ani");
        people.add(p1);
        people.add(p2);

        PersonsList personsList = new PersonsList(people);

        assertEquals("Ingeniero", personsList.clone(p1).getOccupation());
        assertEquals(16, personsList.clone(p1).getId());

    }

    @Test
    void testPersonToFile() throws IOException {
        Person p1 = new Person(1, "Ingeniero", 30, "Juan Perez");
        BufferedWriter mockWriter = mock(BufferedWriter.class);

        PersonsList list = new PersonsList(new ArrayList<>());

        list.personToFile(p1, mockWriter);

        verify(mockWriter).write(p1.toString());
        verify(mockWriter).newLine();

    }
}