package Ironhack.schl;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    //Constructor

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.occupation = occupation;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("A non-negative age value is required.");
        } else {
            this.age = age;
        }
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

    public int getId() {
        return id;
    }


    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name) &&
                this.age == otherPerson.age &&
                this.occupation.equals(otherPerson.occupation);
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


