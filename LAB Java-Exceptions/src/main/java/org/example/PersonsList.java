package org.example;


import java.util.*;

public class PersonsList {
    private List<Person> persons;
    private int nextId = 1000;

    public PersonsList() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        try {
            if (name == null || !name.matches("^[A-Za-z]+\\s[A-Za-z]+$")) {
                throw new IllegalArgumentException("Name must be in the format 'FirstName LastName'.");
            }

            return persons.stream()
                    .filter(p -> p.getFullName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

        } catch (IllegalArgumentException e) {

            throw e;
        } catch (Exception e) {
            System.err.println("Unexpected error in findByName: " + e.getMessage());
            return null;
        }
    }

    public Object clone(Person person1) {
        return null;
    }

    public void writePersonToFile(Person person1, String s) {
    }
}
   

