package com.ironhack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

//Create a PersonsList class that holds a list of Person objects.
//
//Create a findByName method that takes in a string name and returns the Person object with a name that matches exactly. The name parameter should be formatted as "firstName lastName". This method should throw an exception if the name parameter is not properly formatted.
//Create a clone method that takes in a Person object and returns a new Person object with the same properties, except with a new id.
//Create a method that takes in a Person object as a parameter and uses the toString method to write the Person information to a file. This method should handle any errors as necessary.


public class PersonsList extends Person {
    private List<Person> personList;

    //Create a PersonsList class that holds a list of Person objects.
    public PersonsList() {
        this.personList = new ArrayList<>();
    }

    // Create a findByName method that takes in a string name and returns the Person object with a name that matches exactly.
    // The name parameter should be formatted as "firstName lastName". This method should throw an exception if the name parameter
    // is not properly formatted.
    public Person findByName(String name) throws IllegalArgumentException {
        // First, we need to check if the name provided is in the correct format
        if (!isValidNameFormat(name)) {
            throw new IllegalArgumentException("The name format is not correct. It should be in the format 'First Last'");
        }

        // If the name format is valid, we search through our list of people to find a matching name
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                // If a matching name is found, we return the corresponding Person
                return person;
            }
        }
        // If no matching name is found in our list, we return 'null'
        return null;
    }

    // This method checks if the name has the correct format
    private boolean isValidNameFormat(String name) {
        // Here we define the format we consider correct, which is that the name should consist of a first name followed by a space and then a last name
        // For simplicity, we are assuming that both first name and last name should consist of letters only
        // This is a basic validation and may not cover all possible name formats
        return name.matches("^\\w+\\s\\w+$");
    }


//Create a clone method that takes in a Person object and returns a new Person object with the same properties, except with a new id.
    public Person clone(Person originalPerson, int newId) {
        return new Person(newId, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }


// Create a method that takes in a Person object as a parameter and uses the toString method to write the Person information to a file.
// This method should handle any errors as necessary.
    public void writeToFile(Person person) {
        try {
            // Create a new BufferedWriter and FileWriter to write to the file "person_info.txt"
            BufferedWriter writer = new BufferedWriter(new FileWriter("person_info.txt"));
            // Write the Person's information to the file
            writer.write(person.toString());
            // Close the BufferedWriter
            writer.close();
        } catch (IOException e) {
            // If an error occurs while writing to the file, a message is printed to the console
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


    public void addPerson(Person person) {
        personList.add(person);
    }

}