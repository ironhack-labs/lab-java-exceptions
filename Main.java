import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person(0,"Rogerio Ceni",22,"Goleiro");
        Person person1 = new Person(1,"Rodrigo Conde",40,"Software developer"); // ERROR NAME
        Person person2 = new Person(2,"Olavo Carvalho",122,"Caveira");
        Person person3 = new Person(3,"Rodrigo Conde",40,"Software developer"); // DUPLICATED

        // ERROR CASES:
        // Person person1 = new Person(1,"RodrigoConde",12,"Bugado"); // ERROR NAME
        // Person person1 = new Person(1,"RodrigoConde",-2,"Bugado"); // ERROR AGE


        PersonList personList = new PersonList();

        personList.addPerson(person);
        personList.addPerson(person1);
        personList.addPerson(person2);
        personList.addPerson(person3);
        personList.clonePerson(person2); // CLONING PERSON 2
        personList.findByName("Rogerio Ceni");
        personList.findByName("Rodrigo Conde");
        personList.findByName("Gorfo Douro"); // NOT FOUND
        personList.personToFile(person); // WRITE FILE
        System.out.println(person1.equals(person3)); // TRUE
        System.out.println(person1.equals(person2)); // FALSE
    }
}
