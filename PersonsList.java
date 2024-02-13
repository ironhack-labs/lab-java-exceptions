import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }
    public Person findByName(String name) {
        if (name == null || !name.matches("\\w+ \\w+")) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        this.persons.add(person);
    }

    private int generateNewId() {
        return (int) (Math.random() * 10000);
    }

    public Person clone(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        int newId = generateNewId();
        String name = person.getName();
        int age = person.getAge();
        String occupation = person.getOccupation();

        return new Person(newId, name, age, occupation);
    }

    public void writePersonToFile(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("person.txt", true))) {
            writer.println(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

