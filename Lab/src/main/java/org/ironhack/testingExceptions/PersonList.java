package org.ironhack.testingExceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        if (name == null || name.split(" ").length != 2) {
            throw new IllegalArgumentException("Name must be formatted as firstname adn lastname");
        }
        for (Person p : persons) {
            if(p.getName().equals(name)) {
                return  p;
            }
        }
        return null;
    }
    public Person clone(Person person, int newId) {
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writerToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(person.toString() + "\n");
        }catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
