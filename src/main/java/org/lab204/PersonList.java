package org.lab204;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonList {

    List <Person> listPerson;

    public PersonList() {
        this.listPerson = new ArrayList<>();
    }

    public Person findByName(String name){
        String[] separateName = name.split(" ");

        if (separateName.length != 2){
                throw new IllegalArgumentException("Name doesn't have correct format." +
                        " Correct format: \"firstName lastName\"");
        }
        else {
            for (Person person: listPerson){
                if (name.equals(person.getName())){
                    return person;
                }
            }
        }
        return null;
    }

    public Person clone(Person original){

        int id;
        do {
            id = (int) (Math.random() * 500) + 1;
        } while (id == original.getId());

        return new Person(id, original.getName(),
                original.getAge(), original.getOccupation());
    }

    public void toStringFile(Person person){
        try{
            FileWriter writer = new FileWriter("personToFile.txt", true);
            writer.write(person.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //getters
    public List<Person> getListPerson() {
        return listPerson;
    }
}
