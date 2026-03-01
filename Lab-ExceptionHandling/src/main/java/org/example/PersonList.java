package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PersonList {
    private List<Person> people;

    public PersonList(List<Person> people) {
        this.people = people;
    }

    public Person findByName(String name){
        if(name==null || name.trim().split("\\s+").length!=2){
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        for(Person person: people){
            if(Objects.equals(name,person.getName())){
                return person;
            }
        }
        throw new RuntimeException("Name not found");
    }
    public Person clone(Person person){
        if(person == null){
            throw new IllegalArgumentException("Person cannot be null");
        }
        Random random=new Random();
        int newId=random.nextInt(person.getId(),100);
        return new Person(newId,person.getName(),person.getAge(),person.getOccupation());


    }

    public void writePersonToFile(Person person) throws IOException {
        if(person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        try(FileWriter writer=new FileWriter("file.txt",true)){
            writer.write(person.toString());
            writer.write("\n");
        }
    }

}
