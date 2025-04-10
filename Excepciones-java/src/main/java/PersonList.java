import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;

    //Constructor

    public PersonList() {
        this.persons = new ArrayList<>();
    }

    //añadimos una persona a la lista con el metodo addPerson

    public void addPerson(Person person) {
        persons.add(person);
    }

    // Encontrar una persona por su nombre completo metodo findByName

    public Person findByName(String name) {
        if (name == null || !name.matches("^[A-Za-z]+ [A-Za-z]+$")) {
            throw new IllegalArgumentException("El formato tiene que ser 'nombre apellido'");
        }


        //Buscar persona en lista
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        // Si no encontramos una persona nos da valor desconocido

        return null;
    }

    // metodo clone:

    public Person clone(Person original) {
        // generamos una ID
        int newId = original.getId() + 100;

        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
    }

    // Metodo writePersonToFile:

    public void writePersonToFile(Person person) {
        try {
            //aquí creamos un FileWriter
            FileWriter writer = new FileWriter(person.getName().replace(" ", "_") + ".txt");

            //Información de la persona

            writer.write(person.toString());

            //Cerramos el archivo

            writer.close();
            System.out.println("Información guardada correctamente en el documento.");

        } catch (IOException e) {

            //Capturamos y controlamos cualquier posible error en la escritura
            System.err.println("Error al escribir los datos en el documento: " + e.getMessage());
        }

    }
    // Obtención lista de personas:

    public List<Person> getPersons() {
        return persons;
    }

}
