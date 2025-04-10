package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.util.random.RandomGenerator;

public class PersonsList {
private HashMap <String, Person> personsList;

    public PersonsList() {
       personsList = new HashMap<String, Person>();

       Person person1= new Person(10, "Diego Suarez", 31, "Cantante");
       Person person2= new Person(11, "Ana Guerra", 21, "Directora");
       Person person3= new Person(12, "Hugo Sanchez", 27, "Delantero");
       personsList.put(person1.getName(), person1);
       personsList.put(person2.getName(), person2);
       personsList.put(person3.getName(), person3);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        if (!(isCorrectName(name))) {
            throw new IllegalArgumentException();
        }

        if (personsList.containsKey(name)) {
            return personsList.get(name);
        }
        throw new NullPointerException();
    }



    public Person clone(Person p){
        Random random= new Random();
        int newId= random.nextInt();
        Person person= new Person(newId,p.getName(),
                p.getAge(),p.getOccupation());
        return person;
    }

    public boolean isCorrectName (String name){
        String[] nameSurname= name.trim().split(" ");
        if (nameSurname.length == 2){return true;}
        return false;
    }


    public void writePersonToFile (String fileName, Person p) throws IOException {

       try {
           FileWriter myWriter = new FileWriter(fileName, true);
           myWriter.write(p.toString());
           myWriter.close();

       } catch (IOException e) {
           throw new IOException();
       }


    }

    Person getPersonList(String name){return personsList.get(name);}

}
