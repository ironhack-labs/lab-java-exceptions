package com.ironhack;

public class Person {

    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("The age of the person can't be less than 0");
        }
        this.age = age;
    }


    public boolean equals(Person anotherPerson) {
        return this.name.equals(anotherPerson.name) && this.age == anotherPerson.age && this.occupation.equals(anotherPerson.occupation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }
}
