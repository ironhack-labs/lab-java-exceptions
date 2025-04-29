import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class PersonList {
    private final List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    private String getName(String name) {
        String[] find;
        find = name.split(" ");
        return find[0];
    }

    private String getLastName(String name) {
        String[] find;
        System.out.println(name);
        find = name.split(" ");
        try {
            return find[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Name not correctly formatted, must be separated by a ' ' while creating");
            return "Name not correctly formatted, must be separated by a ' ' while creating";
        }
    }

    public void findByName(String fullName) {
        String firstName = this.getName(fullName);
        String lastName = this.getLastName(fullName);
        List<Person> people = getPersonList();
        try {
            for (Person currentPerson : people) {
                String[] nameParts = currentPerson.getName().split(" ");
                if (nameParts.length >= 2 && nameParts[0].equalsIgnoreCase(firstName) && nameParts[1].equalsIgnoreCase(lastName)) {
                    System.out.println("Nome: " + currentPerson.getName() + " ID: " + currentPerson.getId());
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Name must be space separated. Ex.: John Doe");
            return;
        }
        System.out.println("Person " + fullName + " not found.");
    }
    public void clonePerson(Person person){
        Person newPerson = new Person(person.getId()+100,person.getName(), person.getAge(), person.getOccupation());
        this.personList.add(newPerson);
        System.out.println("Created person: " + newPerson.getName() + " - ID: " + newPerson.getId());
    }
    public void personToFile(Person person) throws IOException {
        File filename = new File("person.txt");

        try (FileWriter file = new FileWriter(filename)) {
            file.write("ID: " + person.getId() + "\n");
            file.write("Name: " + person.getName() + "\n");
            file.write("Age: " + person.getAge() + "\n");
            file.write("Occupation: " + person.getOccupation() + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void addPerson(Person person) {
        personList.add(person);
    }
}