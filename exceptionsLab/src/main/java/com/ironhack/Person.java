//Person
package com.ironhack;

public class Person {
    private int id;
    private String fullName;
    private int age;
    private String occupation;

    public Person(int id,String fullName,int age,String occupation){
        this.age=age;
        this.fullName=fullName;
        this.id=id;
        this.occupation=occupation;
    }

    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("Age can't be small than zero!");
        }
        this.age=age;
    }

    public String getFullName(){
        return fullName;
    }
    public int getAge(){
        return age;
    }
    public String getOccupation(){
        return occupation;
    }
    public int getId(){
        return id;
    }


    public boolean equals(Person p){
        return this.fullName.equals(p.fullName)
                && this.age == p.age
                && this.occupation.equals(p.occupation);
    }

}