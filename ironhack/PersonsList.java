package com.ironhack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }


    public Person findByName(String name){
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("The name should be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }

        }

        return null;
    }

    public Person clone(Person person){
        int nextId =0;
        return new Person(nextId++, person.getName(), person.getAge(), person.getOccupation());

    }

    public void writeToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("person.txt"))) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }


    public void add(Person person) {


    }

    public void addPerson(Person person) {persons.add(person);
    }
}
