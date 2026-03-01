package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonList {
    ArrayList<Person> persons = new ArrayList<>();
    public Person findByName(String name){
        if (name == null){
            throw new IllegalArgumentException("name cannot be null");

        }
        String[] fullName = name.trim().split(" ");
        if (fullName.length != 2){
            throw new IllegalArgumentException("Name format must be 'first name last name'");
        }
        for (Person person : persons){
            if (person.getName().equals(name)){
                return person;
            }
        }
        throw new RuntimeException("this name is not find");
    }

    public Person clone(Person person,int newId){
        if (person == null){
            throw new IllegalArgumentException("Person cannot be null");
        }
        Person newPerson = new Person(newId, person.getAge(), person.getName(), person.getOccupation());
        return newPerson;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
    public void personToString(Person person){
        try(FileWriter writer = new FileWriter("perseon-information.txt",true)){
            writer.write(person.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
