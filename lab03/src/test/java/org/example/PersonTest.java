package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAge_LessZero_Error() {
        assertThrows(RangeValues.class, () -> {
            Person myPerson1 = new Person (1234,"John Hood", -1, "Policeman");
            myPerson1.setAge(-1);
        });
    }
}