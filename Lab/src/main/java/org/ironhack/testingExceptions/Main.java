package org.ironhack.testingExceptions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PersonList list = new PersonList();
        Person p1 = new Person(1, "John doe", 30, "Developer");
        Person p2 = new Person(2, "Jane Smith", 25, "Designer");

        list.addPerson(p1);
        list.addPerson(p2);

        try {
            p1.setAge(-5);
        }catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
            list.findByName("InvalidName");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        Person cloned = list.clone(p1,3);
        System.out.println("Cloned person: " + cloned);

        list.writerToFile(cloned, "persons.txt");
    }
}