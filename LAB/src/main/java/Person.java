public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;
    public Person(int id,String name,int age,String occupation){
        this.id=id;
        this.name= name;
        this.age=age;
        this.occupation=occupation;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getOccupation(){return occupation;}


    public void setAge(int age){
        if(age <0)
        {
            throw new IllegalArgumentException("Age cannot be less than zero.");
        }
        else {this.age = age;}
    }

    public boolean equals(Person p){
        if(this == p) return true;
        if(p == null || getClass()!=p.getClass()) return false;
        return name== p.name &&
                age==p.age &&
                occupation==p.occupation;
    }


}
