import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        if (!name.matches("[a-zA-Z]+\\s[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid name format. Use Firstname Lastname");
        }
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person not found");
    }

    public Person clonePerson(Person originalperson, int newId) {
        return new Person(newId, originalperson.getName(), originalperson.getAge(), originalperson.getOccupation());
    }

    public void writePersonToFile(Person person, String filepath) {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
