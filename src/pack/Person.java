package pack;

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

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be a positive value");
        }
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Methods
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return this.name.equals(person.name) &&
                this.age == person.age &&
                this.occupation.equals(person.occupation);
    }
}
