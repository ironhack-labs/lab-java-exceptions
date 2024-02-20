package classes;

import java.io.FileWriter;
import java.io.IOException;

public class PersonsList {
    Person[] listOfPersons;
    public PersonsList(Person[] listOfPersons) {
        setListOfPersons(listOfPersons);
    }

    public Person[] getListOfPersons() {
        return listOfPersons;
    }

    public void setListOfPersons(Person[] listOfPersons) {
        this.listOfPersons = listOfPersons;
    }

    public Person findByName(String name){
        String[] names = name.split(" ");
        if (names.length == 2){
            for(int i = 0; i < listOfPersons.length ;i++){
                if(listOfPersons[i].getName() == name){
                    return listOfPersons[i];
                }
            }
        }else{
            throw new IllegalArgumentException("El nombre tiene un formato incorrecto");
        }
        return listOfPersons[1];
    }
    public Person clone(Person person){
        Person anotherPerson = new Person(person.getId()+1,person.getName(), person.getAge(), person.getOccupation());
        return anotherPerson;
    }

    public void personToFile(Person person){
        try{
            FileWriter writer = new FileWriter("person.txt");
            writer.write(person.toString()+" ID: "+person.getId()+" name: "+person.getName()+" age: "+person.getAge()+" occupation: "+person.getOccupation());
            writer.close();
        }catch (IOException e) {
            System.out.println("Hey that file doesn't exist!");
        }
    }
}
