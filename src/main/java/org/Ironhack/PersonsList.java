package org.Ironhack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person){
        persons.add(person);
    }

    public Person findByName(String name) {
        if (!Pattern.matches("^[A-Za-z]+\\s[A-Za-z]+$", name)) {
            throw new IllegalArgumentException("Name must be in 'firstName lastName' format");
        }

        for (Person p: persons){
            if (p.getName().equals(name)){
                return p;
            }

        }
        return null;
    }
    public Person clone(Person original, int newId){
        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
    }

    public void writePersonToFile(Person person, String fileName){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}