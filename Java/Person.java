
public class Person {

    int id;
    String name;
    int age;
    String occupation;

    private static int instanceCount = 0;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        instanceCount++;
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
        if (!name.matches("[a-zA-Z]+\\s[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name should be formatted as 'firstName lastName'.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be higher than 0");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private static void setInstanceCount(int instanceCount) {
        Person.instanceCount = instanceCount;
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

    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name) &&
                this.age == otherPerson.age &&
                this.occupation.equals(otherPerson.occupation);
    }

}
