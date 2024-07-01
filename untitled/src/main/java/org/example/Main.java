package org.example;

public class Main {
    public static void main(String[] args) {
        // Create some persons for testing
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 25, "Doctor");

        // Test setAge method
        try {
            person1.setAge(-5); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test findByName method
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        try {
            Person foundPerson = personsList.findByName("John Doe");
            System.out.println("Found person: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Person notFoundPerson = personsList.findByName("Invalid Name");
            System.out.println("Found person: " + notFoundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test clone method
        Person clonedPerson = personsList.clone(person2);
        System.out.println("Cloned person: " + clonedPerson);

        // Test writePersonToFile method
        personsList.writePersonToFile(person1, "person1.txt");
        System.out.println("Person information written to file 'person1.txt'.");
    }
}
