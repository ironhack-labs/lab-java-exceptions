package com.ironhack;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    // Constructor
    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    // Method to add a person to the list
    public void addPerson(Person person) {
        this.persons.add(person);
    }

    // Find by name method with validation
    public Person findByName(String name) throws IllegalArgumentException {
        if (!name.matches("[a-zA-Z]+\\s[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    // Clone method
    public Person clonePerson(Person original) {
        return new Person(persons.size() + 1, original.getName(), original.getAge(), original.getOccupation());
    }

    // Write to file method
    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
