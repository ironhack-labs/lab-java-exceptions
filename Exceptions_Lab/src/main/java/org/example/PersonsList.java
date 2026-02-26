package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private List<Person> people = new ArrayList<>();
    private int nextId = 1;

    public void add(Person person) {
        people.add(person);
        if (person.getId() >= nextId) {
            nextId = person.getId() + 1;
        }
    }

    public Person findByName(String name) {
        if (name == null || name.split(" ").length != 2) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public Person clonePerson(Person original) {
        return new Person(nextId++, original.getName(), original.getAge(), original.getOccupation());
    }

    public void writePersonToFile(Person person, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(person.toString());
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}