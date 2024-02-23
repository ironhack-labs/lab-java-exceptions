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

    public void printPerson(Person person) {
        System.out.println(person);
    }


}
