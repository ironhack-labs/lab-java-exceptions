import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
    // Corrected field declarations
    private PersonsList personsList;
    private Person originalPerson;

    @BeforeEach
    void setup() {
        personsList = new PersonsList();
        // Remove the "Person" type here - we're assigning to the field, not declaring a new variable
        originalPerson = new Person(1, "Jimmy J Jackson Jr", 44, "Flatlander");
    }

    @Test
    void clonePerson() {
        Person clonedPerson = personsList.clonePerson(originalPerson);

        // Add assertions here
        assertNotNull(clonedPerson);
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
        assertEquals(originalPerson.getId() + 100, clonedPerson.getId());
    }

    @Test
    void setAge_throwsIllegalArgumentException_ifNegative(){
        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class, ()-> originalPerson.setAge(-1), "Age needs to be positive");

    }

    @Test
    void findByName_correctName_nameFound(){
        //set
        personsList = new PersonsList();
        personsList.personList.add(originalPerson); //person to check
        //do
        Person personFound = personsList.findByName(originalPerson.getName());
        assertEquals(originalPerson.getId(),personFound.getId(),"Found correct person");

        //check
    }
    @Test
    void findByName__invalidFormat_IllegalArgumentException(){
        originalPerson.setName("JimmyJJacksonJr");
        //assertTrue(!originalPerson.name.contains(" "), "Name needs to be First and Last");

        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class, ()-> personsList.findByName("JimmyJJacksonJr"), "Name needs to have First + Last format");


    }
}