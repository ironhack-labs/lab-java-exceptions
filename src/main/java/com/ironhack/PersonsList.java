package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class PersonsList {

    private List<Person> persons = new ArrayList<>();


    public Person findByName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "The name should be in the format of 'firstName and lastName'.");
        }
        for (Person person : persons) {
            if (person.toString().contains(name)) {
                return person;

            }
        }
        return null;

    }

    public <person> Person clone(Person person, int NewId) {
        int newId = 0;
        return person;
    }
    private Class<Object> person() {
        return null;
    }

    public void writePersonToFile(Person person) {
        persons.add(person);
        try {
            FileWriter fileWriter = new FileWriter("persons.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(person.toString());
            printWriter.close();

        } catch (IOException e) {
            throw new RuntimeException("an error occured");


        }
    }
}