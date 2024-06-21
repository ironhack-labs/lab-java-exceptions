import java.util.List;

public class PersonsList {
    private List<Person> personList;


    public PersonsList(List<Person> personList){
        this.personList = personList;
    }

    public Person findByName(String name){
        for (int i = 0; i < personList.size(); i++){
            if (personList.get(i).getName().equals(name)){
                return personList.get(i);
            }

        }
        return null;
    }


    public Person clone (Person p){
        return new Person(p.getId()+1, p.getName(), p.getAge(), p.getOccupation());
    }
}
