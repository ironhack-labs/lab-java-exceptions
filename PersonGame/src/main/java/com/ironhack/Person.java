package com.ironhack;

/**
 * Represents a person with id, name, age and occupation.
 */
public class Person {

    private final int id;
    private String name;
    private int age;
    private String occupation;

    /**
     * Constructs a new Person.
     *
     * @param id         unique identifier
     * @param name       full name in "FirstName LastName" format
     * @param age        age in years
     * @param occupation person's job/occupation
     */
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        setAge(age);  // validation through setter
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

    /**
     * Sets the age of the person.
     *
     * @param age new age value
     * @throws IllegalArgumentException if age is negative
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Compares this person to another person, ignoring the id field.
     *
     * @param other the other Person to compare with
     * @return true if name, age and occupation are equal
     */
    public boolean equals(Person other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return this.name.equals(other.name) &&
               this.age == other.age &&
               this.occupation.equals(other.occupation);
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