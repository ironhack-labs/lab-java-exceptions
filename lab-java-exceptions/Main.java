public static void main(String[] args) {
    try {
        Person person1 = new Person(1234, "Clara Milan", 26 , "Real Estate Agent");
        Person person2 = new Person(1234, "Clara Milan", 26 , "Real Estate Agent");
        System.out.println(person1.equals(person2));

        try {
            person1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected to print 'Age cannot be less than 0.'
        }

    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }

    try {
        Person anotherPerson = new Person(4567, "Mara Pop", 34, "Driver");
        anotherPerson.setAge(-1);
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());







    }
}
