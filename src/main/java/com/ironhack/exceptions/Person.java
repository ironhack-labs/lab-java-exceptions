package com.ironhack.exceptions;

public class Person {
    private static int nextId = 1;
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
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

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                age == person.age &&
                occupation.equals(person.occupation);
    }
    @Override
    public String toString() {
        return "Person: " + getName() + ", age: " + getAge() + ", occupation: " + occupation;
    }
}
















