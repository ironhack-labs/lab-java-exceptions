import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;

public class PersonsList {
    List<Person> personsList = new ArrayList<>();

    public Person findByName(String name) {
        if (!name.contains(" ")) {
            throw new IllegalArgumentException("Name must contain a space separating first and last name.");
        }
        for(Person person : personsList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        return new Person(
                person.getOccupation(),
                person.getAge(),
                person.getName(), // This uses the full name
                Math.abs(UUID.randomUUID().hashCode())
        );
    }

    public void writePersonToFile(Person person, String fileName) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(person.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
