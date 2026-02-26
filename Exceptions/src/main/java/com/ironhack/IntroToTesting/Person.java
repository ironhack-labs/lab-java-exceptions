package com.ironhack.IntroToTesting;

import java.util.Objects;

public class Person {
    private final int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.setName(name);
        this.setAge(age);
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if(age<0){
            throw new IllegalArgumentException("Your age can not be less than zero.");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.contains(" ")){
            throw new IllegalArgumentException("You must write name in format 'firstName lastName'.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public int getId(){
        return id;
    }
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString(){
        return "Person{id='%d', name='%s', age='%d', occupation='%s'}".formatted(id, name, age, occupation);
    }


}
