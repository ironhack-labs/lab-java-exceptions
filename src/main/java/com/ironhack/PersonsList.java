package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class PersonsList {
    private final ArrayList<Person> list = new ArrayList<>();

    public PersonsList() {
    }
    public void add(Person person) {
        this.list.add(person);
    }
    public Person findByName(String name) throws IllegalArgumentException {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException("Name is not properly formatted: 'firstName lastName'");
        }
        for (Person person : list) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private boolean isNameValid(String name) {
        String[] parts = name.split(" ");
        return parts.length == 2;
    }

    public Person clone(Person person) {
        return new Person(person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonInfo(Person person) throws IllegalArgumentException {
        if (person == null) {
            throw new IllegalArgumentException("Person is null");
        }
        try (FileWriter writer = new FileWriter("output/personsInfo.txt", true)) {
            writer.write(person.toString());
            writer.write("=================\n");
            System.out.println("Person information written successfully");
        } catch (IOException exception) {
            System.out.println("Error when writing person info: " + exception.getMessage());
        }
    }

}
