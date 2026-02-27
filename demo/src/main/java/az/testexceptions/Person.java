package az.testexceptions;

import java.util.Random;

public class Person {


    private static int id;
    private static String name;
    private static int age;
    private static String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("age must be greater than 0");
        } else {
            this.age = age;
        }
    }

    public boolean equals(Person anotherPerson){
        if(name == anotherPerson.getName() 
            && age == anotherPerson.getAge()
            && occupation== anotherPerson.getOccupation()){
                return true;

        }
        else{return false;}
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

    public static int getId() {
        return id;
    }

 


}
