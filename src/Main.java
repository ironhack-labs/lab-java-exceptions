public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Shaki Gracia", 23, "Developer");
        Person person2 = new Person(2, "Shaki Gracia", 23, "Developer");

        System.out.println(person1.equals(person2));  // Should print true
    }

    static {Person.PersonsList personsList = new Person.PersonsList();
    }
}
