package ironhack.com;

import java.util.ArrayList;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person (int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;

    }



    public void setAge(int age) {
        this.age = age;
        if(age <= 0){
            throw new IllegalArgumentException("Age cannot be less than 0");
        }

    }

   // public ArrayList

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return name.split(" ")[0];
    }

    public String getLastName() {
        String[] parts = name.split(" ");
        if (parts.length > 1) {
            return parts[parts.length - 1];
        }
        return "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", occupation='").append(occupation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
