import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {

    List<Person> people = new ArrayList<>();

    public Person findByName(String name) {
        if (name.split(" ").length != 2) {
            throw new IllegalArgumentException("Name has to be formatted as 'firstName lastName'");
        }

        return people.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Person clone(Person personToClone) {
        return new Person(people.get(people.size() - 1).getId() + 1,
                personToClone.getName(),
                personToClone.getAge(),
                personToClone.getOccupation());
    }

    public void saveToFile(Person person) {
        try (FileWriter writer = new FileWriter("people.txt", true)) {
            writer.write(person.toString());
        } catch (IOException io_e) {
            System.out.println(io_e.getMessage());
        }
    }

}
