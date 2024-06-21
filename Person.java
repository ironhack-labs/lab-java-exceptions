public class Person {

    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation){
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) throws Exception{
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("age cannot be less than 0");
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Person comp) {
        return (age == comp.getAge() &&
        name.equals(comp.getName()) &&
        occupation.equals(comp.getOccupation()));
    }
}
