package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private static final Pattern NAME_PATTERN = Pattern.compile("^\\p{L}+ \\p{L}+$");

    private final List<Person> persons = new ArrayList<>();
    private int nextId = 1;

    public PersonsList() {}

    public PersonsList(List<Person> initial) {
        if (initial != null) {
            persons.addAll(initial);
            int maxId = initial.stream().mapToInt(Person::getId).max().orElse(0);
            nextId = maxId + 1;
        }
    }

    public void add(Person person) {
        persons.add(person);
        if (person.getId() >= nextId) nextId = person.getId() + 1;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person findByName(String name) {
        if (name == null || !NAME_PATTERN.matcher(name).matches()) {
            throw new InvalidNameFormatException("Name must be formatted as \"firstName lastName\"");
        }
        for (Person p : persons) {
            if (name.equals(p.getName())) return p;
        }
        return null;
    }

    public Person clone(Person person) {
        if (person == null) throw new IllegalArgumentException("Person cannot be null");
        return new Person(nextId++, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person, Path filePath) {
        if (person == null) throw new IllegalArgumentException("Person cannot be null");
        if (filePath == null) throw new IllegalArgumentException("File path cannot be null");

        try {
            Files.createDirectories(filePath.toAbsolutePath().getParent());
            Files.writeString(
                    filePath,
                    person.toString() + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to write person to file", e);
        }
    }
}
