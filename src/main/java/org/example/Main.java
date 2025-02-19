package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("\n####################### Age Method #######################");
//        Person person0 = new Person(446789, "Neymar Junior", -33,"Football Player");
        Person person1 = new Person(528549, "Fernando Balseca", 21,"Estudiante");
        Person person2 = new Person(459874, "Fernando Balseca", 21,"Estudiante");
        Person person3 = new Person(235586, "Cristiano Ronaldo", 41,"Football Player");

        List<Person> personList = new ArrayList<>();
        personList.add(person2);
        personList.add(person3);

        PersonList perList = new PersonList(personList);
        System.out.println(person1);

        System.out.println("\n####################### Equals Method #######################");
        System.out.println("¿ person1 = person2 ? --> " + person1.equals(person2));

        System.out.println("\n####################### Write Person to File Method #######################");
        perList.writePersonToFile(person2, "person.txt");

        System.out.println("\n####################### findByName Method #######################");

        // Try the exact name person
        System.out.println("********************* Try the exact name person *********************");
        Person personByName = perList.findByName("Cristiano Ronaldo");
        System.out.println("Found Person with name " + personByName.getName());

        // Try different name or invalid format
        System.out.println("\n********************* Try different name person And Invalid Format Name *********************");
        Person personInvalidFormat = perList.findByName("Fernando");
        System.out.println(personInvalidFormat);
        Person personNotFound = perList.findByName("Karim Benzema");
        System.out.println(personNotFound);

    }
}