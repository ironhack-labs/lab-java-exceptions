//PersonList
package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> persons = new ArrayList<>();



    public void addPerson(Person p) {
        persons.add(p);
    }

    public Person findByName(String name) throws Exception{
        if (!name.matches("\\w+ \\w+")) {
            throw new Exception("Name must be formatted as 'firstName lastName'");
        }
        for (Person p : persons) {
            if (p.getFullName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Person clonePerson(Person original, int newId) {
        return new Person(newId, original.getFullName(), original.getAge(), original.getOccupation());
    }
}