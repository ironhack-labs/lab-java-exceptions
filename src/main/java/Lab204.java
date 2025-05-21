import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Lab204 {
    public static void main(String[] args) throws IOException {


        System.out.println("Howdy?! this is lab 204");
        //add some test People
        Person person1 = new Person(1, "Jimmy J Jackson Jr", 33, "Flatlander");
        Person person2 = new Person(2, "J W P", 40, "Legendary Flatlander");
        Person person3 = new Person(3, "M D", 38, "Legendary Flatlander");
        PersonsList personsList = new PersonsList();

        try {

            String filePath = "C:\\IronHack\\Practica\\Burn and join\\LAB204\\lab-java-exceptions\\src\\main\\java\\peopleList.txt";
            personsList.personToStringToFile(person3);
            personsList.personToStringToFile(person2);
            personsList.personToStringToFile(person1);


        } catch (IllegalArgumentException e){
            System.out.println("Illegal argument exception: " +e.getMessage());

        }catch (IOException e){
            System.out.println("IOException: " +e.getMessage());
        }


        // clone Person
        System.out.println("ClonePerson Method");

        System.out.println("Original person: " +person1);
        Person clonedPerson = personsList.clonePerson(person1);
        System.out.println("Cloned person" +clonedPerson);



    }

}
