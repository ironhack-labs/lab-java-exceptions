import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonList {
    private static List<Person> person = new ArrayList<>();

    public static Person findByName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be null or " +
                    "empty");
        }
        // trim name
        String nameTrim = name.trim();
        if (!nameTrim.contains(" ")) {
            throw new IllegalArgumentException("you must have a valid name " +
                    "with Name and FirstName");
        }
        // split name
        String[] nameSplit = name.split(" ");
        String nameForFind = nameSplit[0];
        for (Person people : person) {
            if (people.getName().contains(nameForFind)) {
                return people;
            }

        }

        throw new IllegalArgumentException("Person no found with name: "+ name);
    }


    public static Person clone(Person people) throws IllegalArgumentException{
        Random random=new Random();
        int randomId=random.nextInt(1000)+1;
        return new Person(randomId,people.getName(), people.getAge(),
                people.getOccupation());
    }

public static void writePerson(Person people) throws IllegalArgumentException{

            String path="labExceptions/src/main/resources/Persons.txt";
        try{
            FileWriter fileWriter=new FileWriter(path,true);
                fileWriter.write(people.toString());
                fileWriter.close();
        }catch (IOException e){
            throw new IllegalArgumentException("mesage: "+e.getMessage()+" " +
                    "cause: "+e.getCause());
        }



}


    public static void main(String[] args) {
        Person p1=new Person(1,"Ana Ortiz",25,"Abogada");
        Person p2=new Person(2,"Abelardo Gomez",54,"Chatarrero");
        Person p3=new Person(3,"Ismael Suarez",39,"Arquitecto");
        person.add(p1);
        person.add(p2);
        person.add(p3);


        try {
            Person found=findByName("Ana Ortiz");
            System.out.println("Found: "+found);
            Person clone=clone(found);
            System.out.println("Cloned: "+clone);

            writePerson(clone);
        }catch (IllegalArgumentException e){
            System.err.println("Error: "+e.getMessage());
        }





    }






}
