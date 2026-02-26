package org.example;

import java.util.concurrent.RecursiveTask;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation){
        this.id=id;
        if(!name.matches("^[A-za-z]+\\s[A-za-z]+$")){
            throw new IllegalArgumentException("Name should be in this format: firsName LastName");
        }
        else{
            this.name=name;

        }
        this.age=age;
        this.occupation=occupation;
    }

    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("age cant be negative of zero");
        }
        this.age=age;
    }

    public String getName(){
        return name;
    }
    public  int getAge(){
        return  age;
    }
    public String getOccupation(){
        return occupation;
    }

    public int getId(){
        return id;
    }
    public boolean equals(Person person) {
        if (this.name == person.getName() || this.age == person.getAge() || this.occupation == person.getOccupation() || this.id != person.id) {
            return true;
        } else {
            return false;
        }
    }

}
