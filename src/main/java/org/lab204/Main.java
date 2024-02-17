package org.lab204;

public class Main {
    public static void main(String[] args) {

        //instance a Person
        Person person1 = new Person(1,"Julia Olle", 31, "Developer");
        Person person2 = new Person(2,"Pepe Navarro", 45, "Firefighter");

        //create an instance of PersonList and add some elements
        PersonList personList = new PersonList();
        personList.getListPerson().add(person1);
        personList.getListPerson().add(person2);

        //check toString method
        for (Person person : personList.getListPerson()){
            System.out.println(person.toString());
        }

        //check findByName method
        Person personFinded = personList.findByName("Julia Olle");
        System.out.println("person finded: " + personFinded.toString());
        Person personFinded3 = personList.findByName("Julia Roset");

        //check clone method
        Person person3 = personList.clone(person1);
        System.out.println("clone: " + person3.toString());

        //check equals method
        System.out.println("Equals: " + person1.equals(person3));
        System.out.println("Equals: " + person1.equals(person2));

        //check write the Person information to a file
        personList.toStringFile(person1);
    }
}