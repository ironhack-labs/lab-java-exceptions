package org.example;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, int age, String name, String occupation) {
        this.id = id;
        this.age = age;
        this.name = name;
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

    public void setAge(int age) {
        if (age< 0 )
        {
            throw new IllegalArgumentException("Age cannot be less than 0.");
        }else {

            this.age = age;
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean toEquals(Person person){
       if (this.name.equals(person.name) && this.age == person.age && this.occupation.equals(person.occupation)){
           return true;
       }else {
           return false;
       }
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age + ", " + occupation;
    }
}
