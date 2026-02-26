package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonsList {
    private ArrayList<Person> persons = new ArrayList<>();
    private int nextId=1000;


    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findbyName(String name){
        if(!name.matches("^[A-za-z]+\\s[A-za-z]+$")){
            throw new IllegalArgumentException("Name should be in this format: firsName LastName");
        }
        for(Person p: persons){
            if(p.getName()==name){
                return p;
            }
        }
        return null;

    }

    public Person clone(Person original){
        if(original==null){
            throw new IllegalArgumentException("person cant be null");
        }

        Person person=new Person(nextId++, original.getName(), original.getAge(),original.getOccupation());
        return person;
    }

    public void writeToFile(Person person, String filename){
        try(FileWriter writer=new FileWriter(filename, true)){
            writer.write(person.toString()+"\n");
        } catch (IOException e) {
            System.out.println("Error! "+ e.getMessage());
        }
    }
}
