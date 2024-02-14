package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    PersonList myPersonList;
    Person sonia;


    PersonList setList(){
        Person pepe = new Person(1, "Pepe Perez", 30, "fontanero");
        sonia = new Person(2, "Sonia Lopez", 40, "sobrinisima");
        Person juan = new Person(4, "Pepe Perez", 30, "fontanero");
        Person john = new Person(5, "John Doe", 20, "student");
        List<Person> personList = new ArrayList<>();
        personList.add(pepe);
        personList.add(sonia);
        personList.add(juan);
        personList.add(john);
        return new PersonList(personList);

    }
    @BeforeEach
    void setUp(){
        myPersonList = setList();
    }


    @Test
    void findByName_Correct_Data(){
        Person obj = myPersonList.findByName("Sonia Lopez");
        assertEquals(sonia, obj);
    }

    @Test
    void findByName_Incorrect_Format(){
        assertThrows(IllegalArgumentException.class, ()->{
            myPersonList.findByName("SoniaLopez");
        });
    }

    @Test
    void clone_Test(){
        Person clon = myPersonList.clone(sonia);
        assertEquals(clon.getName(), sonia.getName());
        assertEquals(clon.getAge(), sonia.getAge());
        assertEquals(clon.getOccupation(), sonia.getOccupation());
        assertNotEquals(clon.getId(), sonia.getId());
    }

    @TempDir
    static java.nio.file.Path tempDir;

    @Test
    void writePersonToFile_Fnf(){
        String invalidFilePath = tempDir.resolve("nonexistent_directory/nonexistent_file.txt").toString();
        assertThrows(FileNotFoundException.class, ()-> {
            myPersonList.writePersonToFile(sonia, invalidFilePath);
        });
    }

    @Test
    void writePersonToFile_FileExists() throws FileNotFoundException {
        Person somebody = new Person(7, "name name", 30, "profession");
        String filePath = "person.txt";
        myPersonList.writePersonToFile(sonia, filePath);
        assertTrue(Files.exists(Path.of(filePath)));
    }

}