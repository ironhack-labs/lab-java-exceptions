import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;


    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name not valid");
        }
    }

    public boolean isValidName(String name) {
        return !(name.split(" ").length != 2);
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be negative");
        }
        this.age = age;
    }

    public boolean equals(Person person) {
        boolean isNameEqual = Objects.equals(this.getName(), person.getName());
        boolean isAgeEqual = Objects.equals(this.getAge(), person.getAge());
        boolean isOccupationEqual = Objects.equals(this.getOccupation(), person.getOccupation());
        return isNameEqual && isAgeEqual && isOccupationEqual;
    }
}
