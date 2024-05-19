package com.ironhack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void whenAgeIsLessThanO_throwsError(){
        var person = new Person(1,"Bait" ,2,"Barber");

assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
}
     @Test
void whepersonIsCalled(){
         PersonList personsList = new PersonList();
         Person p2 = new Person(2, "Jane Doe", 30, "Doctor");
         personsList.addPerson(p2);


         // Properly formatted name
         try {
             Person foundPerson = personsList.findByName("Jane Doe");
             if (foundPerson != null && foundPerson.equals(p2)) {
                 System.out.println("Test Passed: findByName correctly finds the person");
             } else {
                 System.out.println("Test Failed: findByName did not find the correct person");
             }
         } catch (Exception e) {
             System.out.println("Test Failed: findByName threw an exception for a valid name");
         }
        try {
            Person foundPerson = personsList.findByName("Jane Doe");
            if (foundPerson != null && foundPerson.equals(p2)) {
                System.out.println("Test Passed: findByName correctly finds the person");
            } else {
                System.out.println("Test Failed: findByName did not find the correct person");
            }
        } catch (Exception e) {
            System.out.println("Test Failed: findByName threw an exception for a valid name");
        }}



      @Test
void cloneTest(){
          PersonList personsList = new PersonList();
          Person p2 = new Person(2, "Jane Doe", 30, "Doctor");
          personsList.addPerson(p2)  ;
          Person clonedPerson = personsList.clonePerson(p2);
          if (clonedPerson != null && clonedPerson.getId() != p2.getId() && clonedPerson.equals(p2)) {
              System.out.println("Test Passed: clone creates a new Person with a different ID");
          } else {
              System.out.println("Test Failed: clone did not create a proper clone");
          }}}