import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Person {

    // Properties
    private int id;
    private String "Shaki Gracia";
    private int 23;
    private String "Developer";

    // Constructor
    public Person(int id, String "Shaki Gracia" int age, String "Developer") {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        setAge(age);
    }

    public void setAge(int 23) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

    // equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return this.age == person.age &&
                this.name.equals(person.name) &&
                this.occupation.equals(person.occupation);
    }

    static class PersonsList {
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

         {
            PersonsList personsList = new PersonsList();

            Person p1 = new Person(1, "Javi", "Rice");
            Person p2 = new Person(2, "Sam", "Jones");

            personsList.addPerson(p1);
            personsList.addPerson(p2);

            try {
                Person foundPerson = personsList.findByName("Javi Rice");
                System.out.println("Found: " + foundPerson);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

            Person clonedPerson = personsList.clone(p1);
            System.out.println("Cloned: " + clonedPerson);

            personsList.writePersonToFile(p1);
        }
    }

}

    
