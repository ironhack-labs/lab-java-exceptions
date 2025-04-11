import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        this.persons = new ArrayList<>();
    }

    public PersonList(List<Person> persons) {
        if (persons == null) {
            throw new IllegalArgumentException("La lista de personas no puede ser nula");
        }
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person findByName (String person) throws IllegalArgumentException {
        if (person == null || person.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (!person.contains(" ")) {
            throw new IllegalArgumentException("El nombre no tiene el formato adecuado");
        }
        if (persons.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas está vacía");
        }
      for (Person p : persons) {
            if (p.getName().equals(person)){
                return p;
            }
      }
        return null;
    }

    public Person clone (Person person){
        Random random = new Random();
        return new Person(random.nextInt()+1, person.getName(), person.getAge(), person.getOccupation());
    }

    public void personToFile(Person person) throws IOException {
        try (FileWriter writer = new FileWriter("person.txt", true)) {
            writer.write(person.toString());
        }  catch (Exception e) {
            throw new IOException("Error de archivo: ", e);
        }
    }
}
