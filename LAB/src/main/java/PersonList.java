import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
    public Person findByName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        String[] parts = name.trim().split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'.");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    public Person clone(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        int newId = Math.abs(UUID.randomUUID().hashCode());
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }
    public void writePersonToFile(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        String fileName = "person_" + person.getId() + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.out.println("Error writing person to file: " + e.getMessage());
        }
    }
}