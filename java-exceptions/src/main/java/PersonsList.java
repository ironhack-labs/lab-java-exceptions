import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonsList {
    private ArrayList<Person> persons;

    public PersonsList(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public Person findByName(String name) {
        if (name == null || !name.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
            throw new IllegalArgumentException("Formato de nombre inválido");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person){
        return new Person(person.getId()+15, person.getOccupation(), person.getAge(), person.getName());
    }

    public  void personToFile(Person person, BufferedWriter writer) {
        try {writer.write(person.toString());
            writer.newLine(); // Agrega un salto de línea después de cada persona)
        } catch (IOException e){
            System.err.println("Error al escribir en el archivo" +e.getMessage());
        }

    }
}
