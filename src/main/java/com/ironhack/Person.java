package com.ironhack;

public class Person {
    private static int count = 0;
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        setId(count++);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be greater than zero");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Person comparedPerson) {
        return this.name.equals(comparedPerson.name) && this.age == comparedPerson.age && this.occupation.equals(comparedPerson.occupation);
    }
    public String toString() {
        return String.format("Name: %s\nId: %d\nAge: %d years old\nOccupation: %s\n", getName(), getId(), getAge(), getOccupation());
    }
}
