package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> myList;

    public PersonsList() {
        this.myList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.myList.add(person);
    }

    public List<Person> getPersons() {
        return this.myList;
    }

    public Person findByName(String name){
        Person myPerson = null;
        if(!name.contains(" ")){
            throw new CorrectName("The name format is incorrect.");
        }else{
            for (int i=0; i<this.myList.size(); i++){
                if(name.equals(this.myList.get(i).getName())){
                    myPerson = myList.get(i);
                }
            }
        }

        return myPerson;
    }

    public Person clone(Person person){
        Person myPerson;
        int newId;

        newId = person.getId() +1;
        myPerson = new Person(newId, person.getName(), person.getAge(), person.getOccupation());

        return myPerson;
    }

    public void writeToPerson(Person person) throws IOException {
        String filepath = "src/main/java/org/example/file.txt";

        File file = new File(filepath);
        FileWriter fileToString = new FileWriter(filepath, true);
        fileToString.write(person.toString());
        fileToString.close();


    }

}