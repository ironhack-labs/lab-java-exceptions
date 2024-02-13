import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private List<Person> personList;

    public PersonsList() {
        this.personList = new ArrayList<>();
    }


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Person findByName(String name) {
        if (!name.matches("[a-zA-Z]+\\s[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name should be formatted as 'firstName lastName'.");
        }

        for (Person person : personList) {
            if (person.toString().contains(name)) {
                return person;
            }
        }

        return null;
    }

    public Person clone(Person person){
        int newId = Person.getInstanceCount()+1;
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void docWriter(Person person, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
