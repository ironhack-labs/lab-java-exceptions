package org.example;

import org.example.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonsList{
    List<Person> people=new java.util.ArrayList<>();
   public Person findByName(String name){
       if(name==null || !name.matches("[A-Za-z]+ [A-Za-z]+")){
           throw new IllegalArgumentException("This not be formatted.");
       }
       for(Person person:people){
           if(person.getName().equals(name)){
               return person;
           }
       }
       return null;
   }
    public Person clone(Person person){
        int newId=person.getId()+1;
        return new Person(newId,person.getName(),person.getAge(),person.getOccupation());
    }

    public void file(Person person) {
        try(FileWriter writer=new FileWriter("person_info")){
            writer.write(person.toString());
            System.out.println("Info is written to file");
        } catch (IOException e) {
               System.out.println("Error happened: "+e.getMessage());
       }
    }
}