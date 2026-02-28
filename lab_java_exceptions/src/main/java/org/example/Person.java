package org.example;

public class Person{
    private int id;
    String name;
    int age;
    String occupation;
    public Person(int id, String name, int age, String occupation){
        this.id=id;
        this.name=name;
        this.age=age;
        this.occupation=occupation;
    }
    public int getId(){
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0.");
        }
        this.age = age;
    }


    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public boolean equals(Person object) {
        if (object == null) return false;
        return this.name.equals(object.name) &&
                this.age == object.age &&
                this.occupation.equals(object.occupation);
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    }
}