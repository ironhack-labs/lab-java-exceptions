package com.ironhack;

public class Main {
    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();
        Person person= new Person(1,"Peter Cole",60,"Farmer" );
        personsList.addPerson(person);

        Person person1 = new Person(2,"Emmanuel Essel",30,"Doctor");
        personsList.addPerson(person1);

        Person person2 = new Person(3,"King James",24,"Teacher");
        personsList.addPerson(person2);



    }


}