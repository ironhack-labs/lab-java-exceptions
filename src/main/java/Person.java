import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String occupation;


    public void setAge(Integer age){
        if(age < 0 ) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // 1st Rule Optimization
        if(this == obj) return true;
        // 2nd No null
        if(obj == null ) return false;
        // 3rd obj is Person
        if(obj.getClass() != Person.class) return false;
        // 4. Compare side-by-side
        Person person = (Person) obj;
        return person.getOccupation().equals(this.occupation) && person.getAge().equals(this.age) && person.getName().equals(this.name);
    }
}
