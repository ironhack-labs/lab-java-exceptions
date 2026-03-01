package org.example;

import java.util.Objects;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age<0){
            throw new IllegalArgumentException();
        }
        this.age=age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

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
    @Override
    public String toString(){
        return "Id:"+id
                +"\nName:"+name
                +"\nAge:"+age
                +"\nOccupation:"+occupation;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o ) return true;
        if(o== null || getClass()!=o.getClass()) return false;
        Person person =(Person) o;
        return age==person.age
                && Objects.equals(name,person.getName())
                && Objects.equals(occupation,person.getOccupation());
    }
}
