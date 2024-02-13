public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation){
        this.id= id;
        this.name = name;
        setAge(age);
        this.occupation = occupation;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getOccupation(){return occupation;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("The age is less than zero.");
        }
        this.age = age;}
    public void setOccupation(String occupation){this.occupation = occupation;}

    public boolean equals(Person person){
        boolean isEqual = false;
        if(person.name == name && person.age == age && person.occupation == occupation){
            isEqual = true;
        }
        return isEqual;
    }

}
