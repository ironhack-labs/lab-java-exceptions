package org.example;

import org.testng.annotations.Test;

import java.util.Objects;

public class Person {
private int id;
private String name;
private int age;
private String occupation;
public Person(int id,String name,int age,String occupation){
    this.id=id;
    this.name=name;
    this.age=age;
    this.occupation=occupation;
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
@Test
    public void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("age is not allowed for belove 0");
        }
        this.age = age;
}

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Person other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return java.util.Objects.equals(this.name, other.name) &&
                this.age == other.age &&
                java.util.Objects.equals(this.occupation, other.occupation);
    }
}

