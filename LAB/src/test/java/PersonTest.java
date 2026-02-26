import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;
    @BeforeEach
    void setUp(){
        person = new Person(1234,"Ruzi Xancanov",20,"Student");

    }
    
    @Test
    public void issetAge_ThrowError(){
        assertThrows(IllegalArgumentException.class, ()->{
            person.setAge(-25);
        });
    }
    

}
