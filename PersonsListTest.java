public class PersonsListTest {
    public static void main(String[] args) {
        PersonsList list = new PersonsList();
        list.addPerson(new Person(1, "John Doe", 25, "Engineer"));
        list.addPerson(new Person(2, "Jane Doe", 30, "Doctor"));

        try {
            Person found = list.findByName("John Doe");
            System.out.println("Test passed: " + found);
        } catch (IllegalArgumentException e) {
            System.out.println("Test failed: " + e.getMessage());
        }

        try {
            list.findByName("InvalidName");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed: " + e.getMessage());
        }
    }
}
