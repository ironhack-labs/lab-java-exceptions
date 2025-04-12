import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersonList {
    private List<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        this.personList.add(person);
    }

    public Person findByName(String name) {
        if (name == null || !name.contains(" ")) {
            throw new IllegalArgumentException("Name must be in the format 'FirstName LastName'");
        }
        for (Person person : personList) {

            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }


    public Person clone(Person person) {
        return new Person(person.getId() + 1, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Object o) {

        try (FileWriter fw = new FileWriter("personList.txt", true)) {
            fw.write(o.toString());
        } catch (IOException e) {
            System.out.println("Couldn´t write to file" + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}