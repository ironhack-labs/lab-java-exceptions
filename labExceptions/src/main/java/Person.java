public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) throws IllegalArgumentException {
        if(id<=0){
            throw new IllegalArgumentException("The Id cannot be less than " +
                    "zero");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age<0){
            throw new IllegalArgumentException("The age cannot be less than " +
                    "zero");
        }
        if (occupation.isEmpty()){
            throw new IllegalArgumentException("the occupation cannot be " +
                    "empty");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
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
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException{
        if (age<0){
            throw new IllegalArgumentException("the age cannot be less than " +
                    "zero ");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Person other){
        if (other!=null){
            return this.getName().equals(other.name) && this.getAge() == other.age && this.getOccupation().equals(other.occupation);
        }
        return false;
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
}
