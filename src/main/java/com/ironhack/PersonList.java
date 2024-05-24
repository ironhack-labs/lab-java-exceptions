package com.ironhack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public Person findByName(String name) {
        if (!name.matches("^[a-zA-Z]+ [a-zA-Z]+$")) {
            throw new IllegalArgumentException("Please enter the name in the following format:\n firstName lastName");
        }
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clonePerson(Person person) {
        int newId = generateNewId();
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("person_info.txt"))) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int idCounter = 0;

    private int generateNewId() {
        return ++idCounter;
    }
}
