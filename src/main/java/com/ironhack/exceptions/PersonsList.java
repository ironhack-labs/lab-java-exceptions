package com.ironhack.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> people;
    public PersonsList(List<Person> people) {
        this.people = people;
    }
    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public PersonsList() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
    public Person findByName(String name){
        if (!name.matches("^[a-zA-Z]+ [a-zA-Z]+$")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (Person person : people){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person){
        return new Person(person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person){
        try(FileWriter fw = new FileWriter("person_info.txt",true)) {
            fw.write(person.toString());
        }catch (IOException e){
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
