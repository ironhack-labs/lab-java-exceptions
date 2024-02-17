import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor
    public Person(int id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) throws IllegalArgumentException {
        if ((name.split(" ").length) != 2) {
            throw new IllegalArgumentException("The name property should be formatted as \"firstName lastName\"");
        } else {
            this.name = name;
        }
    }

    //setAge takes in an integer age and sets the age property,
    // but throws an error if age is less than 0.
    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        } else {
            this.age = age;
        }
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Getters
    public int getId() {
        return id;
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

    //An equals method that takes in a Person object and returns true
    // if their properties are the same, excluding the id property.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name)
                && Objects.equals(occupation, person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }
}