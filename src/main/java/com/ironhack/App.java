package com.ironhack;

public class App
{
    public static void main( String[] args ) {
        PersonsList personsList = new PersonsList();
        Person person = new Person("John Doe", 30, "Engineer");
        personsList.writePersonInfo(person);
    }
}
