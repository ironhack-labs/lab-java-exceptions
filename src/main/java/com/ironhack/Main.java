package com.ironhack;

public class Main {
    public static void main(String[] args) {
        // Create a PersonsList
        PersonList personsList = new PersonList();

        // Create and add persons
        Person person1 = new Person(1, "John Doe", 30, "Software Developer");
        Person person2 = new Person(2, "Jane Smith", 25, "Data Scientist");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        // Find a person by name
        try {
            Person foundPerson = personsList.findByName("John Doe");
            System.out.println("Found: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Clone a person with a new id
        Person clonedPerson = personsList.clone(person1, 3);
        System.out.println("Cloned: " + clonedPerson);

        // Write person information to a file
        personsList.writePersonToFile(person1, "person1.txt");
    }
}
