package org.ironhack.testingExceptions;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name =  name;
        setAge(age);
        this.occupation = occupation;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    // equals method (ignores id)
    public boolean equals(Person other) {
        if (other == null) return false;
        return this.name.equals(other.name) &&
                this.age == other.age &&
                this.occupation.equals(other.occupation);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", occupation='" + occupation + '\'' + '}';
    }
}
