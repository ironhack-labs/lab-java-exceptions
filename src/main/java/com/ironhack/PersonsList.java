package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private List<Person> persons = new ArrayList<Person>();

    public Person findByName(String name){

        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Name should be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {

            if (person.toString().contains(name)) {

                return person;

            }

        }
        return null;
    }

    public Person clone (Person person, int newID){

    return new Person(newID, person.getName(), person.getAge(), person.getOccupation());

    }

    public void personsFileWriter(Person person) {
        try {
            FileWriter writer = new FileWriter("persons.txt", true);
            writer.write(person.toString() + "\n");
            writer.close();
        } catch (IOException error) {
            System.err.println("An error occurred while writing to file");
            error.printStackTrace();
        }
    }

}
