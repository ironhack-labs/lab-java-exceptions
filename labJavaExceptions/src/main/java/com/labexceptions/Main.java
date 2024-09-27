package com.labexceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Person person1;

        try {
            person1 = new Person(3, "Juan", 9, "doctor");
            System.out.println(person1.getOccupation());
        } catch (IllegalArgumentException e) {
            System.err.println(("Error edad negativa"));
        }


        Person person2 = new Person(3, "Jorge Rotas", 33, "doctor");
        Person person3 = new Person(6, "Paco Perez", 33, "doctor");

        //Llamamos al método equals de la clase java.
        boolean equalsMain = Person.equals(person2, person3);
        System.out.println(equalsMain);

        System.out.println(person2.getName());

        //Creamos la lista de personas
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person2);
        personsList.addPerson(person3);

        //Llamamos al método findByName de la clase java.

        Person findByName = PersonsList.findByName("Paco Perez");
        System.out.println("Found person - Name: " + findByName.getName() + ", Age: " + findByName.getAge() + ", Occupation: " + findByName.getOccupation());

        //Imprimimos por pantalla las personas que hay en la lista.
        for (Person pele : personsList.getPersons()) {
            System.out.println("ID: " + pele.getId() + ", Name: " + pele.getName() + ", Age: " + pele.getAge() + ", Occupation: " + pele.getOccupation());
        }
        //Llamamos al metodo clone
        Person clone = PersonsList.clone(person3);
        System.out.println("Clone ID number is: " + clone.getId() + " Name is: " + clone.getName() + " Age is: " +  clone.getAge() + " And works as a: " + clone.getOccupation());

        //Creamos el archivo.
        File file = new File(String.valueOf(PersonsList.createFile(person3)));
        file = PersonsList.createFile(person2);


    }


}












