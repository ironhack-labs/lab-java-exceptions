import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person1;
    private Person person2;
    private Person person3;
    private PersonsList personList;
    private final int negativeAge = -28;
    private final String incorrectName = "Maria";

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream outContentClean = System.out;
    @BeforeEach
    void setUp() {
        person1 = new Person(25245,"Maria Villar", 28,"CEO");
        person2 = new Person(68126,"Laia Solas",24,"Taxi driver");
        person3 = new Person(77341,"Silvia Osuna",21,"Consultant");
        personList = new PersonsList(Arrays.asList(person1,person2,person3));
        System.setOut(new PrintStream(outContent));
    }

//    @AfterEach
//    void cleanFiles() {
//        File folder = new File("\\target");
//        File fList[] = folder.listFiles();
//    }

    @DisplayName("Setting incorrect name format")
    @Test
    void setincorrectNameFormat() {
        assertThrows(IllegalArgumentException.class, ()-> new Person(25245,incorrectName, 28,"CEO"));
        assertThrows(IllegalArgumentException.class, ()-> person1.setName(incorrectName));
    }

    @DisplayName("Setting negative age")
    @Test
    void setNegativeAge() {
        assertThrows(IllegalArgumentException.class, ()-> new Person(25245,"Maria Villar", negativeAge,"CEO"));
        assertThrows(IllegalArgumentException.class, ()-> person1.setAge(negativeAge));
    }

    @DisplayName("Equal objects with different ids")
    @Test
    void testEquals() {
        Person person11 = new Person(68126,person1.getName(),person1.getAge(),person1.getOccupation());
        assertEquals(person1,person11);
    }

    @DisplayName("findbyName: finding person")
    @Test
    void findByName_successful() {
        assertEquals(person2,personList.findByName("Laia Solas"));
    }

    @DisplayName("findbyName: person not in list")
    @Test
    void findByName_personNotPresent() {
        assertThrows(NullPointerException.class, ()->personList.findByName("Laura Puertas"));
    }

    @DisplayName("findbyName: name not properly formatted")
    @Test
    void findByName_incorrectName() {
        assertThrows(IllegalArgumentException.class, ()->personList.findByName("Laia"));
    }

    @DisplayName("clonePerson: successful")
    @Test
    void clonePerson() {
        Person personClone = personList.clonePerson(person3);
        assertEquals(personClone,person3);
//        assertEquals(personClone.getName(),person3.getName());
//        assertEquals(personClone.getAge(),person3.getAge());
//        assertEquals(personClone.getOccupation(),person3.getOccupation());
        assertNotEquals(personClone.getId(),person3.getId());
    }

    @DisplayName("Write one person info in file, when file already exists") // works when file already exists
    @Test
    void writingPersonInfoinFile_when_file_alreadyExists() throws IOException {
        personList.writePersonInfo(person1);
        assertEquals("Updating current existing file about " + person1.getName(), outContent.toString().trim());
        personList.writePersonInfo(person1);
        assertTrue(new File("Info about " + person1.getName() + ".txt").exists());

    }

    @DisplayName("Write one person info in file, when file does not exist") // works when file does not exist
    @Test
    void writingPersonInfoinFile_when_file_doesnotExist() throws IOException {
        personList.writePersonInfo(person1);
        assertEquals("Updating current existing file about " + person1.getName(), outContent.toString().trim());
        personList.writePersonInfo(person1);
        assertTrue(new File("Info about " + person1.getName() + ".txt").exists());

    }


}