package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonList {
    private List<Person> personList;

    public PersonList() {

    }

    public PersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "personList=" + personList +
                '}';
    }

    public Person findByName(String name) {
        // Verify that name has the format "firstName lastName"
        if (name.split(" ").length != 2) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }

        // Find the exact name Person
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        throw new IllegalArgumentException("Person with name " + name + " not found.");
    }

    // Create a clone method that takes in a Person object and returns a new Person object with the same properties, except with a new id.
    public Person clone(Person person) {
        int newPersonId = (int) (Math.random() * 900000) + 100000; // Random between 100000-900000

        return new Person(newPersonId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person, String fileName) {
        File file = new File(fileName);

        try {
            // Create a new FileWriter object to write to the file
                                                            // TO ADD A NEW PERSON
            FileWriter writer = new FileWriter(file, true);
            // Write some text to the file
            writer.write(person.toString() + "\n");
            // Close the writer to save the changes
            writer.close();
            System.out.println("File written successfully");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
