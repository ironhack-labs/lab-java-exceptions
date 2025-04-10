package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args)  {

        PersonsList personsLis = new PersonsList();
        Person p=personsLis.findByName("Ana Guerra");

        try {
            personsLis.writePersonToFile("myFile.txt", p);
        } catch (Exception e){e.getMessage();}
    }
}