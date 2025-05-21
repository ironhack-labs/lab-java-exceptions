public class Person {
    int id;
    String name;
    String firstName;
    String lastName;
    int age;
    String occupation;

    //Setters and getters

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
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.name = this.firstName + " " + this.lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.name = this.firstName + " " + this.lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0 ");
        }
        this.age = age;
    }

    public String getOccupation () {
        return occupation;
    }

    public void setOccupation (String occupation){
        this.occupation = occupation;
    }

    // constructors

    public String fullName (String name){
        this.name = (this.firstName + " " + this.lastName);
        return this.name;
    }


    //  constructor   id, name, age, occupation


    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", firstName='" + firstName + '\'' +
                // ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
