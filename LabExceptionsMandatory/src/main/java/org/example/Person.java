package org.example;

public class Person {
    private int id;
    private String name; //a string formatted as "firstName lastName
    private int age;
    private String occupation;


    public Person(int id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
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

    public int getAge()  {


        return age;
    }

    public void setAge(int age)  throws IllegalArgumentException {
        if (age<0){
            throw new IllegalArgumentException("Valor de edad incorrecto");
        }

        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Person p){
        if (this.name.equalsIgnoreCase(p.getName())
                && this.age==p.getAge()
                && this.occupation.equalsIgnoreCase(p.getOccupation())){
            return true;
        }
        return false;
    }

    //check name format name  space  surname
    public static boolean isCorrectName (String name){
        String[] nameSurname= name.trim().split(" ");
        if (nameSurname.length == 2){return true;}
        return false;
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
