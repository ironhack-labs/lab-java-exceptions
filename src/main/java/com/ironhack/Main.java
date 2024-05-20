package com.ironhack;

import net.datafaker.Faker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        var list = new ArrayList<Person>();


        for (int i = 0; i < 2; i++) {

            Person person =new Person(214,faker.name().fullName(), 33, faker.job().position());
            list.add(person);

        }




    }
}