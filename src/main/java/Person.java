import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(String occupation, int age, String firstName, String lastName, int id) {
        this.occupation = occupation;
        this.age = age;
        this.name = firstName + " " + lastName;
        this.id = id;
    }

    public Person(String occupation, int age, String fullName, int id) {
        this.occupation = occupation;
        this.age = age;
        this.name = fullName;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
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

    public void setName(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Person person){
        return person.age == age &&
                Objects.equals(person.name, name) &&
                Objects.equals(person.occupation, occupation);
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
