import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Person {
    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}

class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }

        String[] parts = name.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];

        for (Person person : persons) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null; // or throw an exception if preferred
    }

    public Person clone(Person person) {
        int newId = generateNewId();
        return new Person(newId, person.getFirstName(), person.getLastName());
    }

    public void writePersonToFile(Person person) {
        try (FileWriter writer = new FileWriter("person.txt")) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private boolean isValidName(String name) {
        return Pattern.matches("^[a-zA-Z]+ [a-zA-Z]+$", name);
    }

    private int generateNewId() {
        return persons.size() + 1;
    }

    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();

        Person p1 = new Person(1, "John", "Doe");
        Person p2 = new Person(2, "Jane", "Smith");

        personsList.addPerson(p1);
        personsList.addPerson(p2);

        try {
            Person foundPerson = personsList.findByName("John Doe");
            System.out.println("Found: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        Person clonedPerson = personsList.clone(p1);
        System.out.println("Cloned: " + clonedPerson);

        personsList.writePersonToFile(p1);
    }
}
