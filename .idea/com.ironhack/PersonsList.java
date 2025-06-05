package main.java.com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public Person findByName(String name) {
        if (!Person.isValidName(name)) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clonePerson(Person person, int newId) {
        return person.clone(newId);
    }

    public void writePersonToFile(Person person, String filename) {
        person.writeToFile(filename);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
