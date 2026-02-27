package com.ironhack;

public class Main {
    public static void main(String[] args) {

        PersonsList list = new PersonsList();

        Person p1 = new Person(1, "Ali Aliyev", 28, "Software Engineer");
        list.addPerson(p1);

        Person found = list.findByName("Ali Aliyev");
        System.out.println("Found: " + found);

        Person copy = list.clone(p1);
        System.out.println("Clone: " + copy);

        list.writePersonToFile(p1, "people.txt");
        System.out.println("Written to file: people.txt");
    }
}