package az.testexceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class PersonList {

    private static Random rd = new Random();

    private static FileWriter fw;

    private static String fileName = "personData.txt";

    private static File file = new File(fileName);

    private List<Person> personList;

    public Person findByName(String name) {


        if (!isFullName(name)) {

            throw new IllegalArgumentException("you entered wrong full name");
        } else {
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getName().equals(name)) {
                    return personList.get(i);
                }
            }
        }
        return null;

    }

    public static Person clone(Person person){


        return new Person(rd.nextInt(), person.getName(), person.getAge(), person.getOccupation());

    }

    public static void writeToFile(Person person){

        

        try {
            FileWriter writer = new FileWriter(file, true);

            writer.write(person.toString()); 
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        


    }




    public static boolean isFullName(String name) {
        if (name == null)
            return false;

        String[] parts = name.trim().split(" ");
        return parts.length == 2 && !parts[0].isEmpty() && !parts[1].isEmpty();
    }

}
