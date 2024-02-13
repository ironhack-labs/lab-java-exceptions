package pack;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class PersonsList {
    private List<Person> persons;

    // Constructor
    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    // Methods
    public Person findByName(String name) throws IllegalArgumentException {
        String[] nameParts = name.split(" ");

        if (nameParts.length != 2) {
            throw new IllegalArgumentException("The name should be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    private int generateNewId() {
        return (int) (Math.random() * 1000);
    }

    public Person clone(Person originalPerson) {
        int newId = generateNewId();
        return new Person(newId, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }

    public void writeToFile(Person person, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error when writing to file: " + e.getMessage());
        }
    }
}
