package org.Ironhack;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person(1, "Alice Smith", 30, "Engineer");
        Person p2 = new Person(2, "Bob Johnson", 45, "Manager");


        PersonsList list = new PersonsList();
        list.addPerson(p1);
        list.addPerson(p2);

        // Test setAge with valid and invalid value
        try {
            p1.setAge(35);
            System.out.println("Set age to 35: OK");

            p1.setAge(-5); // Should throw error
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for invalid age: " + e.getMessage());
        }

        // Test findByName with correct format
        try {
            Person found = list.findByName("Alice Smith");
            System.out.println("Found: " + found);
        } catch (Exception e) {
            System.out.println("Unexpected error during findByName: " + e.getMessage());
        }

        // Test findByName with incorrect format
        try {
            list.findByName("InvalidNameFormat");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for name format: " + e.getMessage());
        }

        // Test clone
        Person clone = list.clone(p1, 3);
        System.out.println("Cloned person: " + clone);

        // Test equals (excluding id)
        System.out.println("p1 equals clone? " + p1.equals(clone));

        // Test write to file
        list.writePersonToFile(p1, "person.txt");
        System.out.println("Person info written to file.");
    }
}