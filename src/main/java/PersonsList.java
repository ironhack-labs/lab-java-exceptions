import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {

    private List<Person> persons;

    public PersonsList(){
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person){
     persons.add(person);
    }
    public Person findByName(String name){
        if(!isValidNameFormat(name)){
            throw new IllegalArgumentException("Name parameter is not properly formatted");
        }
        for(Person person : persons){
               if(person.getName().equals(name)){
                   return person;
               }
        }
        return null;
    }

    public Person clone(Person originalPerson){
        return new Person(persons.size()+1, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }
    public void writeToTextFile(Person person){
        try(FileWriter writer = new FileWriter("person.txt")){
            writer.write(person.toString());
        } catch(IOException e){
System.err.println("Error writing to file "+ e.getMessage());
        }
    }

    private boolean isValidNameFormat(String name){
        return name != null && name.matches("^\\w+\\s\\w+$");
    }
}
