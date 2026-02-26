package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    List<Person> people=new ArrayList<>();
    public void addPerson(Person person){
        people.add(person);
    }
    public Person findByName(String name){
        if (!Person.isValidName(name)) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        for(Person person: people){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
    public Person clone(Person person){
        if(person==null) throw new NullPointerException("Person is null");
        return new Person(5,person.getName(),person.getAge(),person.getOccupation());
    }
    public void printPersonInfo(Person person) throws IOException {
        if(person==null) throw new NullPointerException("Person is null");
        try(FileWriter fileWriter=new FileWriter("Person Information.txt")) {
            fileWriter.write(person.toString());
        } catch (IOException e) {
            throw new IOException("Error writing Person to file:");
        }
    }
}
