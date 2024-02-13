package org.example;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class PersonList {
    private List<Person> people;

    public PersonList(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Person findByName(String name){
        String[] strName = name.split(" ");
        if(strName.length != 2){
            throw new IllegalArgumentException("Name has to be: 'firstName lastName'");
        }
        for (Person person : people){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person){
        return new Person(person.getId()+1, person.getName(), person.getAge(), person.getOccupation());
    }

    public void toString(Person person){
        String strPerson = "{"+person.getId() + ", " + person.getName() + ", " + person.getAge() + ", " + person.getOccupation() +"}";
        try {
            FileWriter writer = new FileWriter("person.txt");
            writer.write(strPerson);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            // Handle the exception (e.g., create the file, prompt the user, etc.)
        } catch (SecurityException e) {
            System.err.println("Security exception: " + e.getMessage());
            // Handle the exception (e.g., check permissions, prompt the user, etc.)
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

