package com.ironhack;

//Create a Person class that has the following properties:
//
//    id: an integer
//    name: a string formatted as "firstName lastName"
//    age: an integer
//    occupation: a string

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

//The Person class should have the following methods:
//
//    A constructor that takes in an integer id, a string name, an integer age and a string occupation as arguments and sets their respective properties.
//    A setAge method that takes in an integer age and sets the age property, but throws an error if age is less than 0.
//    An equals method that takes in a Person object and returns true if their properties are the same, excluding the id property.

    //    A constructor that takes in an integer id, a string name, an integer age and a string occupation as arguments and sets their respective properties.
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person() {
    }

    //    A setAge method that takes in an integer age and sets the age property, but throws an error if age is less than 0.
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

//    An equals method that takes in a Person object and returns true if their properties are the same, excluding the id property.
    public boolean equals(Person otherPerson) {
       // return this.name.equals(otherPerson.name) && this.age == otherPerson.age && this.occupation.equals(otherPerson.occupation);
        if (this.name.equals(otherPerson.name)) {
            if (this.age == otherPerson.age) {
                if (this.occupation.equals(otherPerson.occupation)) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Age: " + this.age + ", Occupation: " + this.occupation;
    }



    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getOccupation() {
        return occupation;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}