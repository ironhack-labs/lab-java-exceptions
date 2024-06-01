package com.ironhack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        this.persons = new ArrayList<>();
    }

    // Add a person to the list
    public void addPerson(Person person) {
        this.persons.add(person);
    }

    // Find a person by name
    public Person findByName(String name) {
        if (!name.matches("^[a-zA-Z]+ [a-zA-Z]+$")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null; // Or throw an exception if person is not found
    }

    // Clone a person with a new id
    public Person clone(Person person, int newId) {
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    // Write person information to a file
    public void writePersonToFile(Person person, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

