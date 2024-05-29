import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private List<Person> persons; // List to store Person objects

    public PersonsList() {
        persons = new ArrayList<>(); // Initializing the list
    }

    // Method to add a Person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Method to find a Person by name, throws an error if name is not properly formatted
    public Person findByName(@NotNull String name) {
        if (!name.matches("^[A-Za-z]+ [A-Za-z]+$")) {
            throw new IllegalArgumentException("Name must be properly formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person; // Return the found person
            }
        }
        return null; // Return null if no person is found
    }

    // Method to create a clone of a Person with a new ID
    public Person clone(@NotNull Person person) {
        int newId = persons.size() + 1; // Generate a new ID
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    // Method to save a Person's information to a file
    public void saveToFile(@org.jetbrains.annotations.NotNull Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
