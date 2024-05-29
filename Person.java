public class Person {

    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor to initialize the Person object with given parameters
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    // Method to set the age, throws an error if age is less than 0
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

    // Method to compare if two Person objects are equal excluding the id
    public boolean equals(Person other) {
        return this.name.equals(other.name) &&
                this.age == other.age &&
                this.occupation.equals(other.occupation);
    }

    // Method to convert Person object to a string
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getOccupation() { return occupation; }
}
