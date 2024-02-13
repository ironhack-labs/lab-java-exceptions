

public class PersonListTests {
    public static void main(String[] args){
        testSetAgeMethod();
        testFindByNameMethodWithProperFormat();
        testFindByNameMethodWithImproperFormat();
        testCloneMethod();
    }


    public static void testSetAgeMethod(){
        Person person = new Person(1, "Pepito Perez",30, "Engineer");
        try {
            person.setAge(-5);
            System.out.println("Test failed: setAge method did not throw an error for negative age");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed: setAge method correctly threw an error for negative age");
        }
    }
    public static void testFindByNameMethodWithProperFormat() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Pepito Perez", 30, "Ingeniero");
        Person person2 = new Person(1, "Paco Pecas", 20, "Gracioso");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        Person foundPerson = personsList.findByName("Pepito Perez");
        if (foundPerson != null && foundPerson.equals(person1)) {
            System.out.println("Test passed: findByName method returned the correct Person object for a properly formatted name");
        } else {
            System.out.println("Test failed: findByName method did not return the correct Person object for a properly formatted name");
        }
    }
    public static void testFindByNameMethodWithImproperFormat() {
        PersonsList personsList = new PersonsList();
        try {
            Person foundPerson = personsList.findByName("PepitoPerez");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed:findByName method correctly threw an exception for improperly formatted name");
        }
    }
        public static void testCloneMethod() {
            Person originalPerson = new Person(1, "John Doe", 30, "Engineer");
            PersonsList personsList = new PersonsList();
            Person clonedPerson = personsList.clone(originalPerson);
            if (clonedPerson.getAge() == originalPerson.getAge() &&
                    clonedPerson.getName().equals(originalPerson.getName()) &&
                    clonedPerson.getOccupation().equals(originalPerson.getOccupation()) &&
                    clonedPerson.getId() != originalPerson.getId()) {
                System.out.println("Test passed: clone method correctly created a new Person object with the same properties as the original, except with a new id");
            } else {
                System.out.println("Test failed: clone method did not correctly create a new Person object with the same properties as the original, except with a new id");
            }
        }


}

