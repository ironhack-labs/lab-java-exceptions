import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> persons;
    private int nextId = 1;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    // Finds a person by name
    public Person findByName(String name) throws IllegalArgumentException {
        if (!name.contains(" ") || !Pattern.matches("[a-zA-Z]+ [a-zA-Z]+", name)) {
            throw new IllegalArgumentException("Name must be properly formatted as 'firstName lastName'.");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null; // or throw an exception if a person must be found
    }

    // Clones a person object
    public Person clone(Person person) {
        return new Person(nextId++, person.getName(), person.getAge(), person.getOccupation());
    }

    // Write Person's information to a file
    public void writePersonToFile(Person person, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(person.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Assuming a toString method in the Person class
    // public String toString() {
    //     return "Id: " + id + ", Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    // }
}

