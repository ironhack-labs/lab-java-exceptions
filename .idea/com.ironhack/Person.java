package main.java.com.ironhack;

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

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

    public boolean equals(Person other) {
        if (other == null) return false;
        return this.name.equals(other.name) &&
                this.age == other.age &&
                this.occupation.equals(other.occupation);
    }

    public Person clone(int newId) {
        return new Person(newId, this.name, this.age, this.occupation);
    }

    public void writeToFile(String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            writer.write(this.toString());
        } catch (java.io.IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Age: " + this.age + ", Occupation: " + this.occupation;
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z]+\\s[A-Za-z]+$");
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getOccupation() { return occupation; }
}

