import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class PersonsList {

    private List<Person> persons;

    public PersonsList(List<Person> persons){
        setPersons(persons);
    }

    public List<Person> getPersons(){return persons;}
    public void setPersons(List<Person> persons){this.persons=persons;}
    public Person findByName(String name) throws IllegalArgumentException{
        Person matchingPerson = null;
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        String[] splitName = name.split(" ");
        if(splitName.length != 2){
            throw new IllegalArgumentException("The format of the name is wrong. Should be name lastname.");
        }

        for(Person person:persons){
            if(person.getName().equals(name)){
                matchingPerson = person;
            }
        }

        if(matchingPerson == null){
            throw new IllegalArgumentException("No person found named "+name);
        }
        return matchingPerson;
    }
    public Person clone(Person person){
        Person newPerson = new Person(2,person.getName(),person.getAge(),person.getOccupation());
        return newPerson;
    }

    public void toFile(Person person, String filename) throws IOException {

        if(person == null){
            throw new IllegalArgumentException("Person cannot be null");
        }
        if(filename.isEmpty() || filename == null){
            throw new IllegalArgumentException("Filename cannot be empty or null");
        }

        try(FileWriter writer = new FileWriter(filename)){
            writer.write(person.toString());
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }

}
