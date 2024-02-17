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

        //check toString method: print a String with information of person
        for (Person person : personList.getListPerson()){
            System.out.println(person.toString());
        }

        //check findByName method: find a person who has the name entered as a parameter
        try {
            Person personFound = personList.findByName("Julia Olle");
            if (personFound != null){
                System.out.println("Person found: " + personFound.toString());
            } else{
                System.out.println("Person not found.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //check clone method
        Person person3 = personList.clone(person1);
        System.out.println("clone: " + person3.toString());

        //check equals method
        System.out.println("Equals: " + person1.equals(person3));

        //check write the Person information to a file
        personList.toStringFile(person1);
    }
}