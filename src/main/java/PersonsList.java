import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PersonsList {
    // class that holds a list of Person objects.
    private List<Person> personList;

    public PersonsList(List<Person> personList) {
        this.personList = personList;
    }

    // findByName method takes a string name and returns the corresponding Person object
    // The name parameter should be formatted as "firstName lastName".
    // This method should throw an exception if the name parameter is not properly formatted.
    public Person findByName (String name) throws IllegalArgumentException {
        if ((name.split(" ").length) != 2) {
            throw new IllegalArgumentException("The name property should be formatted as \"firstName lastName\"");
        } else {
            for (Person person : personList) {
                if (Objects.equals(person.getName(), name)) {
                    return person;
                }
            }
        }
        throw new NullPointerException("There is not any person in the list with the specified name");
    }

    // clone method takes a Person object and returns
    // a new Person object with the same properties, except with a new id.
    public Person clonePerson (Person person) {
        Random random = new Random();
        int randomId = random.nextInt(1000000);
        return new Person(randomId, person.getName(), person.getAge(),person.getOccupation());
    }

    // method takes a Person object as a parameter and uses the toString method
    // to write the Person information to a file.
    // This method should handle any errors as necessary.
    public void writePersonInfo (Person person) throws IOException {
        try {
            File file = new File("Info about " + person.getName() + ".txt");
            String message = " Id: "+person.getId() + "\n Name: " +person.getName() + "\n Age: " + person.getAge() + "\n Occupation: " + person.getOccupation();

            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Creating new file about " + person.getName());
                message = "**Original info at " + new Date() + "** \n" + message;
            } else {
                System.out.println("Updating current existing file about " + person.getName());
                message = "\r\n\n**Updated info at " + new Date() + "** \n" + message;
            }

            FileWriter writer = new FileWriter("Info about " + person.getName() + ".txt",true);
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            System.out.println("There was an error when creating the file: " + e.getMessage());
        }
    }
}