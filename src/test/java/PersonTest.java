import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PersonTest {

    Person person1;
    Person person2;
    PersonList personList;

    @Test
    @DisplayName("Should throws an exception when the age is negative")
    void setAge_wrong_age_throws() {
        person1 = new Person(1, "firstName1 lastName1", 41, "Computer engineer");

        assertThrows(IllegalArgumentException.class, () -> person1.setAge(-1));
    }

    @Test
    @DisplayName("Should return the correct person by the correct formatted name")
    void findByName_return_a_person() {
        person1 = new Person(1, "firstName1 lastName1", 41, "Computer engineer");
        person2 = new Person(2, "firstName2 lastName2", 42, "Computer engineer");
        personList = new PersonList();
        personList.people.add(person1);
        personList.people.add(person2);

        assertTrue(new Person(2, "firstName2 lastName2", 42, "Computer engineer").equals(
                personList.findByName("firstName2 lastName2")));
    }

    @Test
    @DisplayName("Should throws an exception when the name is not well formatted")
    void findByName_wrong_name_throws() {
        person1 = new Person(1, "firstName1 lastName1", 41, "Computer engineer");
        person2 = new Person(2, "firstName2 lastName2", 42, "Computer engineer");
        personList = new PersonList();
        personList.people.add(person1);
        personList.people.add(person2);

        assertThrows(IllegalArgumentException.class, () -> personList.findByName("name1"));
    }

    @Test
    @DisplayName("Should clone a person with the same properties except by the id")
    void clone_a_person() {
        person1 = new Person(1, "firstName1 lastName1", 41, "Computer engineer");
        personList = new PersonList();
        personList.people.add(person1);
        person2 = personList.clone(person1);

        assertTrue(person1.equals(person2));
        assertFalse(person1.getId() == person2.getId());
    }

}