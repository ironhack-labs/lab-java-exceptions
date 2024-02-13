import lombok.AllArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class PersonList {
    private List<Person> personList;

    public Person findByName(String name) throws IllegalArgumentException {
        if (name.split(" ").length != 2)
            throw new IllegalArgumentException("Name has to be formatted as firstName lastName");
        for (Person person : personList) {
            if (person.getName().equals(name))
                    return person;
        }
        return null;
    }

    public Person clone(Person src) {
        return new Person(src.getId() + 1, src.getName(), src.getAge(), src.getOccupation());
    }

    public void personWriter(Person src) {
        try {
            FileWriter writer = new FileWriter(src.getId() + ".txt");
            writer.write(src.getName() + " " + src.getAge() + " " + src.getOccupation());
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot write into file");
        }



    }

}
