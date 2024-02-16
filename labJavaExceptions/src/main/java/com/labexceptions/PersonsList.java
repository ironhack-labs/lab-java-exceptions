package com.labexceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonsList {

    private static List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public static Person findByName(String name) {
        Utils.checkName(name);
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person with the name " + name + " not found.");
    }

    public static Person clone(Person person) {
        Random random = new Random();
        Integer id = random.nextInt(20);
        String name = person.getName();
        Integer age = person.getAge();
        String occupation = person.getOccupation();
        return new Person(id, name, age, occupation);
    }

    public static File createFile(Person person) throws IOException {
        File file = new File("persons.txt");
        FileWriter writerFile = new FileWriter(file, true); //con append true, añadimos contenido.
        BufferedWriter writer = new BufferedWriter(writerFile);

        try {

            writer.write(person.toString());
            writer.write("ID: " + person.getId());
            writer.newLine();
            writer.write("Name: " + person.getName());
            writer.newLine();
            writer.write("Age: " + person.getAge());
            writer.newLine();
            writer.write("Occupation: " + person.getOccupation());

            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        return file;

    }



}
