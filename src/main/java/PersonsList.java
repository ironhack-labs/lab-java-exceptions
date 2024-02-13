import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonsList {
    private List<Person> personsList;

    public PersonsList() {
        this.personsList = new ArrayList<>();
    }
    public void addPerson(Person person) {
        personsList.add(person);
    }

    public Person findByName(String name) {
        if (isValidName(name)) {
            for (Person item : personsList) {
                if (Objects.equals(name, item.getName())) {
                    return item;
                }
            }
            return null;
        } else {
            throw new IllegalArgumentException("Name not valid");
        }
    }

    public boolean isValidName(String name) {
        return !(name.split(" ").length != 2);
    }

    public Person clone(Person person) {
        return new Person(person.getId()+1, person.getName(), person.getAge(), person.getOccupation());
    }

    public void toString(Person person) {
        String stringPerson =   "id: " + person.getId() +
                                "name: " + person.getName() +
                                "age: " + person.getAge() +
                                "occupation: " + person.getOccupation();

        writeFile(stringPerson);
    }

    public void writeFile(String person) {
        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write(person);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
