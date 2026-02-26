package com.ironhack.IntroToTesting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private Person[] persons;
    private int count;

    public PersonsList(int size) {
        this.persons = new Person[size];
        this.count = 0;
    }

    public Person findByName(String name){
        if (name == null || !name.contains(" ")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        for (int i = 0; i < count; i++) {
            if (persons[i].getName().equals(name)) {
                return persons[i];
            }
        }
        return null;
    }
    public Person clone(Person person, int newId){
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        Person clone = new Person(newId, person.getName(), person.getAge(), person.getOccupation());
        addPerson(clone);
        return clone;
    }
    public void toFile(Person person, String fileName){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(person.toString());
        }
        catch (IOException e){
            System.out.println("Error when tried to write to file: " + e.getMessage());
        }
    }
    public void addPerson(Person person) {
        if (count < persons.length) {
            persons[count] = person;
            count++;
        }
    }
}

