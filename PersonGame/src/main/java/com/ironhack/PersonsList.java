package com.ironhack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of Person objects.
 */
public class PersonsList {

    private final List<Person> persons = new ArrayList<>();
    private int nextId = 1;

    public void add(Person person) {
        persons.add(person);
    }

    /**
     * Finds a person by exact full name.
     *
     * @param name full name in "FirstName LastName" format
     * @return the matching Person
     * @throws IllegalArgumentException if name format is invalid
     * @throws java.util.NoSuchElementException if no person found
     */
    public Person findByName(String name) {
        if (name == null || !name.matches("^[A-Z][a-z]+ [A-Z][a-z]+$")) {
            throw new IllegalArgumentException(
                "Name must be in format 'FirstName LastName' with capital first letters. Got: " + name);
        }

        return persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new java.util.NoSuchElementException("Person not found with name: " + name));
    }

    /**
     * Creates a deep copy of the given person with a new unique id.
     *
     * @param person the person to clone
     * @return new Person instance with same properties except id
     */
    public Person clone(Person person) {
        Person cloned = new Person(
            nextId++,
            person.getName(),
            person.getAge(),
            person.getOccupation()
        );
        return cloned;
    }

    /**
     * Writes person's toString() representation to a file.
     *
     * @param person   person to save
     * @param filename target file path
     * @throws IOException if file operation fails
     */
    public void saveToFile(Person person, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(person.toString());
            writer.newLine();
        }
    }
}