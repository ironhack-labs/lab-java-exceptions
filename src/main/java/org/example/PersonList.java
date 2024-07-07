package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {

    public static class PersonsList {
        private List<Person> persons;

        public PersonsList() {
            this.persons = new ArrayList<>();
        }

        // Method to add a person to the list
        public void addPerson(Person person) {
            persons.add(person);
        }

        // Method to find a person by name
        public Person findByName(String name) {
            if (!name.contains(" ")) {
                throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
            }
            for (Person person : persons) {
                if (person.getName().equals(name)) {
                    return person;
                }
            }
            return null;
        }

        // Method to clone a person
        public Person clone(Person person) {
            return new Person(persons.size() + 1, person.getName(), person.getAge(), person.getOccupation());
        }

        // Method to write person to file
        public void writePersonToFile(Person person, String filename) {
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(person.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}