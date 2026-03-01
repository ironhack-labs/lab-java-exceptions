package ironhack.Persons;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonsList {
    ArrayList<Person> persons = new ArrayList<>();
    public Person findByName(String name){
        if (name == null){
            throw new IllegalArgumentException("Name can't be null!");

        }
        String[] fullName = name.trim().split(" ");
        if (fullName.length != 2){
            throw new IllegalArgumentException("Name format must be 'first name last name'!");
        }
        for (Person person : persons){
            if (person.getName().equals(name)){
                return person;
            }
        }
        throw new IllegalArgumentException("Name not found");
    }

    public Person clone(Person person, int newId){
        if (person == null){
            throw new IllegalArgumentException("Person can't be null!");
        }
        Person newPerson = new Person(newId, person.getName(), person.getAge(), person.getOccupation());
        return newPerson;
    }

    public void personToString(Person person){
        try(FileWriter writer = new FileWriter("persons.txt",true)){
            writer.write(person.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
