package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        // Checks for white spaces
        if (!name.contains(" ")) {
            throw new IllegalArgumentException("Full name should be written seperately.Example:  FirstName LastName");
        }

        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null; // if not found
    }
    // clone metodudu
    public Person clone(Person person) {
        // everything stays we just change id
        return new Person(person.getId() + 100, person.getName(), person.getAge(), person.getOccupation());
    }

    // writes to file
    public void writeToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(person.toString() + "\n");
        } catch (IOException e) {
            System.err.println("There was an error when attempted to FileWriting: " + e.getMessage());
        }
    }
}
