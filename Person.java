public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.setAge(age);  // Using the setAge method to enforce age validation
        this.occupation = occupation;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

    // Getter and Setter for occupation
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Equals method to compare Person objects excluding the id property
    public boolean equals(Person other) {
        if (other == null) {
            return false;
        }
        return this.name.equals(other.name) && this.age == other.age && this.occupation.equals(other.occupation);
    }

    // Method to display Person details (optional, for testing purposes)
    public void displayPerson() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Occupation: " + occupation);
    }
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + ", occupation='" + occupation + "'}";
    }

}
