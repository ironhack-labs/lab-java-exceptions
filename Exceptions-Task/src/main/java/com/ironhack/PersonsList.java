package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private List<Person> persons = new ArrayList<>();
    private int nextId = 1000;

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {

        if (name == null || !name.matches("^[A-Za-z]+\\s[A-Za-z]+$")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public Person clone(Person person) {
        return new Person(
                nextId++,
                person.getName(),
                person.getAge(),
                person.getOccupation()
        );
    }

    public void writeToFile(Person person, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(person.toString());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
