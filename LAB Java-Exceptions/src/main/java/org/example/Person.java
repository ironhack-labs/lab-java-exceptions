package org.example;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;

    public Person(int id, String firstName, String lastName, int age, String occupation) throws IllegalArgumentException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setAge(age);
        this.occupation = occupation;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0.");
        }
        this.age = age;
    }

    public boolean equals(Person other) {
        if (other == null) return false;
        return this.getFullName().equals(other.getFullName()) &&
                this.age == other.age &&
                this.occupation.equals(other.occupation);
    }

    public String toString() {
        return "ID: " + id + ", Name: " + getFullName() + ", Age: " + age + ", Occupation: " + occupation;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}