package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonList {
    private List<Person> people=new ArrayList<>();

    public void addPerson(Person person){
        people.add(person);
    }

    public Person findByName(String name){
        if(!name.matches("^[a-zA-Z]+\\\\s[a-zA-Z]+$")){
            throw new IllegalArgumentException("Ad formatı səhvdir! 'Ad Soyad' şəklində olmalıdır.");
        }
        for(Person p : people){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Person clone(Person person, int newId){
        return new Person(newId,person.getName(),person.getAge(),person.getOccupation());
    }
    public void writeToFile(Person person, String fileName){
        try(FileWriter writer=new FileWriter(fileName,true)){
            writer.write(person.toString()+"\n");
            System.out.println("File succesfully written "+fileName);
        } catch (IOException e){
            System.err.println("An error occured "+e.getMessage().toLowerCase());
        }
    }
}
