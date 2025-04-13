package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {


    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2) {
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
        return new Person(Person.NEXT_ID++, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Person person, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(person.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
