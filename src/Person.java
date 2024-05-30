import java.util.Objects;
import java.util.StringJoiner;

public class Person {


    public Object get;
    public String getOccupation;


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

    public Person(String number, String zZohn) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return id == person.id && age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(occupation, person.occupation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("occupation='" + occupation + "'")
                .toString();
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;


    }

    public Object split() {
        return new Person(id, name, age, occupation);
    }

}

