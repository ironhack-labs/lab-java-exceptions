package com.ironhack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;

    public  PersonList() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        if (!name.matches("^[a-zA-Z]+ [a-zA-Z]+$")) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    private int generateNewId() {
        return persons.size() + 1;  // Simple id generation logic, can be improved
    }

    public Person clonePerson(Person person) {
        if (!persons.contains(person)) {
            throw new IllegalArgumentException("Person does not exist");
        }
        return new Person(generateNewId(), person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Person person){
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        var file = new File("persons.txt");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
