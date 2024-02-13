import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age has to be a positive number");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getAge() == person.getAge() && getOccupation().equals(person.getOccupation());
    }
}