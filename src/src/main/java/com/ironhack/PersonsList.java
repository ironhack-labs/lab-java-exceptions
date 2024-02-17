package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList(List<Person> persons) {
        this.persons = new ArrayList<>(persons);
    }

    public Person findByName(String name) {
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Name should be formatted as 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person) {
        return new Person(person.getId() + 1, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonInfo(Person person) throws IOException {
        FileWriter writer = new FileWriter("demo.txt", true);
        try {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } finally {
            writer.close();
        }
    }
}