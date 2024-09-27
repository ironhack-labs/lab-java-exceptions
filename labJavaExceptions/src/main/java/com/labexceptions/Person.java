package com.labexceptions;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String occupation;

    public Person(Integer id, String name, Integer age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Utils.checkName(name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age){
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public static boolean equals(Person person, Person person2) {
        if (person.getName().equals(person2.getName()) && person.getAge().equals(person2.getAge()) && person.getOccupation().equals(person2.getOccupation())) {
            return true;
        } else {
            return false;
        }
    }

}
