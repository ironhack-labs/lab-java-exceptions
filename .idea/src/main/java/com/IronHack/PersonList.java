package com.IronHack;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//Create a PersonsList class that holds a list of Person objects.
public class PersonList {
    private List<Person> people;
    //Create a findByName method that takes in a string name and returns the Person object with a name that matches exactly. The name parameter should be formatted as "firstName lastName".
    // This method should throw an exception if the name parameter is not properly formatted.


    public Person findByName(String name) {
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2) {
            throw new RuntimeException("Name should formatted as 'firstName lastName'");
        }
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        for (Person person : people) {
            if (firstName.equals(person.getFirstName()) && lastName.equals(person.getLastName())) {
                return person;
            }
        }
        return null;
    }
    //Create a clone method that takes in a Person object and returns
    // a new Person object with the same properties, except with a new id.
    public Person clone (){
        try{
            Person clonesdPerson = (Person) super.clone();
            clonesdPerson.setId(Person.getNextId());
        }catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        return clone();


    }
    //Create a method that takes in a Person object as a parameter and uses the toString method to write the Person information to a file.
    // This method should handle any errors as necessary.
    public void writePersonToFile(Person person, String fileName) {
        try(PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println(person.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }



}
