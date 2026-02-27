package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private final List<Person> people;
    private int nextId = 1000; // clone üçün yeni id generator

    public PersonsList() {
        this.people = new ArrayList<>();
    }

    public PersonsList(List<Person> people) {
        this.people = people;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person findByName(String name) {
        validateFullName(name);

        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    private void validateFullName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        String trimmed = name.trim();
        String[] parts = trimmed.split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        if (parts[0].isBlank() || parts[1].isBlank()) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
    }

    public Person clone(Person p) {
        int newId = nextId++;
        return new Person(newId, p.getName(), p.getAge(), p.getOccupation());
    }

    public void writePersonToFile(Person p, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(p.toString());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write person to file: " + filePath, e);
        }
    }
}