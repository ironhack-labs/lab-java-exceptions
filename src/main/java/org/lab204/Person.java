package org.lab204;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    //constructor
    public Person(int id, String name, int age, String occupation) {
        setId(id);;
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    //Override Methods toString Hashcode and Equals.
    @Override
    public String toString() {
        return "Id: " + id + " | Name: " + name +
                " | Age: " + age + " | Occupation: " + occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getOccupation(), person.getOccupation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getOccupation());
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if(name == null || !name.contains(" ")) {
            throw new IllegalArgumentException("Name doesn't have correct format." +
            " Correct format: \"firstName lastName\"");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must not be less than 0.");
        } else {
            this.age = age;
        }
   }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    //getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOccupation() {
        return this.occupation;
    }
}
