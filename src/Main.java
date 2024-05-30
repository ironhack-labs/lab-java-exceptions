import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {


        Person person = new Person(26, "ZZohn Decker", 45, "Web Developer");

        System.out.println("\"The name should be in the format of 'firstName and lastName'.\");");


        class Person {
            private String firstName;
            private String lastName;

            public Person() {
                firstName = lastName = String.valueOf(4);
            }

        }
    }

}
