import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PersonList list = new PersonList();
        Person person1 = new Person(1, "Arian, Collaso", 31, "IT");
        list.addPerson(person1);
        Person foundPerson = list.findByName("Arian, Collaso");
        System.out.println(foundPerson.getName());

        Person clonedPerson = list.clone(foundPerson);

        System.out.println(clonedPerson.getName());
        list.personToString(clonedPerson);
    }
}
