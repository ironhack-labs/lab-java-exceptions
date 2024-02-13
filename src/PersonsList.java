import java.util.List;

public class PersonsList {

    private List<Person> persons;

    public PersonsList(List<Person> persons){
        setPersons(persons);
    }

    public List<Person> getPersons(){return persons;}
    public void setPersons(List<Person> persons){this.persons=persons;}
    public Person findByName(String name){
        //Chequear formato del nombre


        for(Person person:persons){
            if(person.getName() == name){
                return person;
            }
        }
    }
    public Person clone(Person person){
        Person newPerson = new Person(2,person.getName(),person.getAge(),person.getOccupation());
        return newPerson;
    }


}
