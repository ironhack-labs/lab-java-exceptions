package com.ironhack;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.occupation = occupation;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age should be over 0.");
        }
        this.age = age;
    }

    public static String name (String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Strings cannot be null or empty");
        }
        return firstName + " " + lastName;
    }
    public boolean equals(Object o) {  //id-den basqalari eyni olmalidi daxil elediyinle expectedin
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(occupation, person.occupation);
    }
    @Override   //yaziya cevirir
    public String toString() {
        return "Persons ID is: " + id + ", Name is: " + name + ", Age is: " + age + ", Job is: " + occupation;
    }

}
