import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


class PersonTest {
    private Person person;
    @BeforeEach
        void StUpPerson(){
        person=new Person(1,"Ana Ortiz",36,"Abogada");
    }
    @Test
    @DisplayName("Check age cannot be less than zero")
    void setAge_cannot_be_less__tahn_zero() {
        assertThrows(IllegalArgumentException.class,()->person.setAge(-2));
    }
}