import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    List<Person> personList;
    //constructor
    public PersonsList() {
        this.personList = new ArrayList<>();
    }



    //findByName method
    public Person findByName(String name) throws IllegalArgumentException {
        if (!name.contains(" ")) {
            throw new IllegalArgumentException("Name must contain First name AND last name");
        }
        for (Person person : personList){
            if (person.getName().equals(name)){
                return person;
            }
        }
        throw new IllegalArgumentException("Person not found");

    }


    //clonePerson  method  this should use new ID

    public Person clonePerson (Person person) throws IllegalArgumentException{
        int newId = person.getId()+100;

        for (Person existingPerson : personList){
            if (existingPerson.getId() == newId){
                throw new IllegalArgumentException("Id already in use!");
            }
        }
        Person clonedPerson = new Person(newId, person.getName(),person.getAge(), person.getOccupation());
        return clonedPerson;

    }

    // to string but validating info


    public void personToStringToFile (Person person) throws IllegalArgumentException, IOException {
        if (person == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (!person.getName().contains(" ")){
            throw new IllegalArgumentException ("Name must contain first AND last name");
        }
        if(person.getAge()< 0){
            throw new IllegalArgumentException("Age cannot be less than 0");
        }

        String filePath = "C:\\IronHack\\Practica\\Burn and join\\LAB204\\lab-java-exceptions\\src\\main\\java\\peopleList.txt";

        File file = new File(filePath);
        File directory = file.getParentFile();

        if (!directory.exists()) {
            directory.mkdirs();
        }

        //knowledge u gap
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write(person.toString() + System.lineSeparator());
        }

        //return person.toString();

    }


}


//if (!name.contains(" ")) {
//            throw new IllegalArgumentException("Name must contain First name AND last name");
//        }