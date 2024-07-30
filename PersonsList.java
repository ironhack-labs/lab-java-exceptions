import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }
    // Method to find Person by Name
    public Person findByName(String name) throws IllegalArgumentException {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name must be in 'firstName lastName' format.");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private boolean isValidName(String name) {
        // Simple regex to validate 'firstName lastName' format
        return Pattern.matches("[A-Za-z]+ [A-Za-z]+", name);
    }

    // Method to clone a Person with a new ID
    public Person clone(Person person) {
        // Increment ID by 1 for the new clone (simple approach)
        return new Person(generateNewId(), person.getName(), person.getAge(), person.getOccupation());
    }

    private int generateNewId() {
        // Generate a new ID based on existing IDs in the list (simple approach)
        int newId = 1;
        for (Person person : persons) {
            if (person.getId() >= newId) {
                newId = person.getId() + 1;
            }
        }
        return newId;
    }

    // Method to write Person information to a file
    public void writePersonToFile(Person person, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

}
