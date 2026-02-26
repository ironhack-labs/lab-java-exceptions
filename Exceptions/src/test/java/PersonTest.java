import com.ironhack.IntroToTesting.Person;
import com.ironhack.IntroToTesting.PersonsList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;
    @BeforeEach
    void setUp() {
        person = new Person(0, "Pablo Escobario", 24, "Occupation");
    }

    @Test
    void setAge_throwsException_ageLessThanZero() {
        assertThrows(IllegalArgumentException.class, () ->
                person.setAge(-4)
        );
    }

    @Test
    void findByName_returnsCorrectPerson() {
        PersonsList list = new PersonsList(5);
        list.addPerson(person);
        Person found = assertDoesNotThrow(() -> list.findByName("Pablo Escobario"));
        assertEquals("Pablo Escobario", found.getName());
    }

    @Test
    void findByName_throwsException_badFormat() {
        PersonsList list = new PersonsList(5);
        list.addPerson(person);
        assertThrows(IllegalArgumentException.class, () ->
                list.findByName("PabloEscobario")
        );
        assertThrows(IllegalArgumentException.class, () ->
                list.findByName("Pablo")
        );
    }

    @Test
    void clone_createsNewPersonWithSamePropertiesButNewId() {
        PersonsList list = new PersonsList(5);
        Person original = person;
        list.addPerson(original);

        Person cloned = list.clone(original, 1);

        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
        assertNotEquals(original.getId(), cloned.getId());
    }

    @Test
    void toFile_isWorking(){
        PersonsList list = new PersonsList(5);
        list.addPerson(person);
        String fileName="newFile.txt";
        list.toFile(person, fileName);
        try(Scanner scanner = new Scanner(new File(fileName))){
            assertEquals("Person{id='0', name='Pablo Escobario', age='24', occupation='Occupation'}",scanner.nextLine());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}