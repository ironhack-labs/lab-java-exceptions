package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void removePerson(Person person) {
        personList.remove(person);
    }

    public Person getPerson(int index) {
        return personList.get(index);
    }

    public Person findByName(String name) {
        String[] parts = name.split(" ");
        if (parts.length < 2)
            throw new IllegalArgumentException("name should follow firstName lastName format");
        for (Person person : personList) {
            if (person.getName().equals(name))
                return person;
        }
        return null;
    }


    public Person clone(Person person, int id) {
        if (person.getId() == id)
            throw new IllegalArgumentException("Please use a different ID");
        else
            return new Person(id, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person) {
        try {
            FileWriter writer = new FileWriter("person.txt");
            writer.write(person.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
