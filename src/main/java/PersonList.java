import java.io.FileWriter;
import java.io.IOException;

public class PersonList {
    private Person[] personList;

    public PersonList(Person[] personList) {
        this.personList = personList;
    }

    public Person findByName( String name) throws IllegalArgumentException{
        if (!name.matches("[a-zA-Z]+\\s[a-zA-Z]+")){
            throw new IllegalArgumentException("Invalid name format. Use Firstname Lastname");
        }
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person not found");
    }

    public Person clonePerson(Person originalperson, int newId){
        return new Person(newId, originalperson.getName(), originalperson.getAge(), originalperson.getOccupation());
    }

    public void writePersonToFile(Person person, String filepath){
        try {
            FileWriter writer = new FileWriter(filepath);
            writer.write(person.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
