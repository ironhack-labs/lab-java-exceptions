package org.example;

import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons = new ArrayList<>();
    private int nextId = 1;
    public Person findByName(String name){
        String []parts=name.trim().split("\\s++");
        if (parts.length<2){
            throw new IllegalArgumentException("parameter is not properly formatted");
        }
    for (Person p:persons){
        if (p.getName().equals(name)){
            return p;
        }
    }
    throw new IllegalArgumentException("sehvsen qaqa");
    }

public Person clone(Person person){
       return new Person(nextId++,person.getName(),person.getAge(), person.getOccupation());
}
public void writer(Person person,String filename) throws IOException {
try(FileWriter writer=new FileWriter(filename,true)){
    writer.write(person.toString());
} catch (IOException e) {
    System.out.println("error happened ");
}
}
        public void add(Person person) {
            persons.add(person);
            if (person.getId() >= nextId) {
                nextId = person.getId() + 1;
            }
        }
    }
