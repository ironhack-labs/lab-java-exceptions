package com.ironhack;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public Person findByName(String name) {
        if(!name.matches("^[a-zA-Z] + [a-zA-Z]")) {
            throw new IllegalArgumentException("Name must formated as 'firstName lastName' ");
        }
        for (Person person : persons){
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone (Person person){
        int newId = person.getId() + 100;

        return new Person (newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writerPersonToFile(Person person){
        try (FileWriter writer = new FileWriter("persons_infor.txt")){
            writer.write(persons.toString() + "\n");
        }catch (IOException e) {
            System.err.println("Error writting to the faile: " + e.getMessage());
        }
    }
}