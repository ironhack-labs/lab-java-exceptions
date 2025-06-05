package main.java.com.ironhack;

public class PersonTest {
    public static void main(String[] args) {
        try {
            Person p1 = new Person(1, "John Doe", 30, "Engineer");
            p1.setAge(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Passed: " + e.getMessage());
        }

        Person p1 = new Person(1, "John Doe", 30, "Engineer");
        Person p2 = new Person(2, "Jane Doe", 28, "Doctor");
        Person p3 = new Person(3, "John Doe", 30, "Engineer");
        System.out.println("p1 equals p3: " + p1.equals(p3));
        System.out.println("p1 equals p2: " + p1.equals(p2));

        Person p4 = p1.clone(4);
        System.out.println("Cloned Person: " + p4);

        p1.writeToFile("person.txt");

        PersonsList pl = new PersonsList();
        pl.addPerson(new Person(1, "John Doe", 30, "Engineer"));
        pl.addPerson(new Person(2, "Jane Doe", 28, "Doctor"));

        try {
            Person foundPerson = pl.findByName("John Doe");
            System.out.println("Found Person: " + foundPerson);

            pl.findByName("JohnDoe");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Passed: " + e.getMessage());
        }

        Person clonedPerson = pl.clonePerson(p1, 5);
        System.out.println("Cloned Person with new ID: " + clonedPerson);

        pl.writePersonToFile(p1, "person_test.txt");
    }
}

