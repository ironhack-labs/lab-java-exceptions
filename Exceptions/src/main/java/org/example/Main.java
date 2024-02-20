package org.example;

import classes.Person;
import classes.PersonsList;

public class Main {
    public static void main(String[] args) {
        Person persona = new Person(1,"Xavi",12,"QA engineer");
        Person persona2 = new Person(1,"Xavi Tirado",12,"QA engineer");
        Person[] lista = {persona,persona2};
        PersonsList listadopersonas = new PersonsList(lista);
        listadopersonas.personToFile(persona);
    }
}