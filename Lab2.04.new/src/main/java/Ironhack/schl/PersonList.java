package Ironhack.schl;

import java.util.List;
import java.util.stream.Collectors;

public class PersonList {
    private List<Person> personList;

    public PersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person findByName(String name) throws IllegalArgumentException {
        String[] fullName = name.split(" ");
        if (fullName.length != 2) {
            throw new IllegalArgumentException("Please enter your first and last name separated by a space.");
        }
        String firstName = fullName[0];
        String lastName = fullName[1];

        return personList.stream()
                .filter(person -> person.getName().equals(firstName + " " + lastName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The person was not found."));
    }


    public Person clone(Person person) {
        int newId = personList.stream()
                .mapToInt(Person::getId)
                .max()
                .orElse(0) + 1;

        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Person person, String filePath) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(filePath);
            fileWriter.write(person.toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred when writing to file: " + e.getMessage());

        }
    }
}