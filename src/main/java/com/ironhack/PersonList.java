package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;
    private  int counterId=1;

    public PersonList() {
        this.persons = new ArrayList<>();
    }


    public Person addPerson(String name, int age, String occupation) {
        Person person = new Person(counterId++, name, age, occupation);
        persons.add(person);
        return person;
    }



    public  Person findBynName(String name) throws Exception {

       String[]names = name.split(" ");

        if (names.length != 2) {
            throw new Exception("Invalid name format. Please provide a first and last name.");
        }



        for (Person person : persons) {
                if (person.getName().equalsIgnoreCase(name)) {
                    return person;
                }
        }


        throw new Exception("Person not found with the name: " + name);

    }


    public Person clonePerson(Person person) {
        return new Person(counterId++, person.getName(), person.getAge(), person.getOccupation());
    }


    @Override
    public String toString() {
        return "PersonList{" +
                "persons=" + persons +
                '}';
    }


    public void writeToFile(Person person, String filePath) {
        try(FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(person.toString()+"\n");
            System.out.println("Person information written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }




    }



