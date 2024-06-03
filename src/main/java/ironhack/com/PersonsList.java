package ironhack.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList(){
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person){

    }

    public boolean removePerson(int id) {
        return false;
    }

    public Person findByName(String name){
        for(Person person:persons){
            if(person.getName().equalsIgnoreCase(name)){
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person){
        int new_id = person.getId();
        person.setId(new_id++);
        return person;
    }

    public void personLogger(Person person, String filePath) {
        String personData = person.toString();

        try {
            // Write the string representation to a file
            Files.write(Paths.get(filePath), (personData + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            // Handle any I/O errors
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    }


