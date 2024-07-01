package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    // Add a person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Find a person by name
    public Person findByName(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person with name '" + name + "' not found.");
    }

    // Clone a person with a new id
    public Person clone(Person original) {
        Person clonedPerson = new Person(
                generateNewId(), // Assuming you have a method to generate a new unique id
                original.getName(),
                original.getAge(),
                original.getOccupation()
        );
        return clonedPerson;
    }

    // Write person information to a file
    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Generate a new id (example method, replace with actual implementation)
    private int generateNewId() {
        // Example implementation, replace with logic to generate unique ids
        return (int) (Math.random() * 1000);
    }
}
