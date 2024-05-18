package com.IronHack;
//Create a Person class that has the following properties:
//
//id: an integer
//name: a string formatted as "firstName lastName"
//age: an integer
//occupation: a stringCreate a Person class that has the following properties:
//
//id: an integer
//name: a string formatted as "firstName lastName"
//age: an integer
//occupation: a string

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
    private static int nextId = 1;
    //A constructor that takes in an integer id, a string name,
    // an integer age and a string occupation as arguments and sets their respective properties.

    public Person(int id, String name, int age, String occupation) {
        this.id = nextId++;
        this.firstName = name;
        this.lastName = name;
        this.age = age;
        this.occupation = occupation;

    }
    //A setAge method that takes in an integer age and sets the age property,
    // but throws an error if age is less than 0.

    public int getAge() {
        return age;
        if (age <= 0) {
                throw new RuntimeException("Age can not be less than z-e-r-o!");
            }
        }

        public void setAge ( int age){
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
        }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = nextId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Person.nextId = nextId;
    }

    public String getOccupation () {
            return occupation;
        }

        public void setOccupation (String occupation){
            this.occupation = occupation;
        }
        //An equals method that takes in a Person object and returns true if their properties are the same,
        // excluding the id property.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(occupation, person.occupation);
        }


}

