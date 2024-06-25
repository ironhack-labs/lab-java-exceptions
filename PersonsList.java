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

    // Method to add a Person to the list
    public void addPerson(Person person) {
        this.persons.add(person);
    }

    // Method to find a Person by name
    public Person findByName(String name) {
        if (!name.matches("[a-zA-Z]+ [a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;  // Return null if no match is found
    }

    // Method to clone a Person with a new id
    public Person clone(Person person, int newId) {
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    // Method to write Person information to a file
    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();

        // Adding persons to the list
        Person person1 = new Person(1, "John Doe", -1, "Software Engineer");
        Person person2 = new Person(2, "Jane Smith", 28, "Doctor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        // Finding a person by name
        try {
            Person foundPerson = personsList.findByName("John Doe");
            Person foundPerson2 = personsList.findByName("JohnDoe");
            System.out.println("Found person: " + foundPerson);
            System.out.println("Found person: " + foundPerson2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Cloning a person with a new id
        Person clonedPerson = personsList.clone(person1, 3);
        System.out.println("Cloned person: " + clonedPerson);

        // Writing a person to a file
        personsList.writePersonToFile(person1, "person1.txt");
    }
}
