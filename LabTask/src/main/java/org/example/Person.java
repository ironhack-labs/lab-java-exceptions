package org.example;

import java.util.Objects;

public class Person {
    private final int id;
    private final String name;
    private int age;
    private final String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        setAge(age);
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

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be less than 0");
        this.age = age;
    }

    public boolean equals(Person other) {
        if (other == null) return false;
        return Objects.equals(this.name, other.name)
                && this.age == other.age
                && Objects.equals(this.occupation, other.occupation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person other)) return false;
        return Objects.equals(name, other.name)
                && age == other.age
                && Objects.equals(occupation, other.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
