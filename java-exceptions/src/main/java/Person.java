public class Person {
    private final int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String occupation, int age, String name) {
        this.id = id;
        setOccupation(occupation);
        setAge(age);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if( age <= 0){
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Person otherPerson){

        return this.name.equals(otherPerson.name)
                && this.age == otherPerson.age
                && this.occupation.equals(otherPerson.occupation);
    }
}
