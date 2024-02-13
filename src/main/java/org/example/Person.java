package org.example;

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
        if(isNameFormatted(name)) {
            this.name = name;
        }

    }

    public boolean isNameFormatted(String name){
        String[] strName = name.split(" ");
        if(strName.length != 2){
            throw new IllegalArgumentException("Name has to be: 'firstName lastName'");
        }
        return true;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Age can not be negative");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;  // Same object reference, they are equal
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  // Objects are of different types or null
        }
        Person person = (Person) obj;  // Cast the object to Person

        return this.getName().equals(person.getName()) && this.getAge() == person.getAge()
                && this.getOccupation().equals(person.getOccupation());

    }
}

