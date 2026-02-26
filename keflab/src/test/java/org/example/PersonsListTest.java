package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
  private PersonsList pl;
  private Person person1;
  private Person person2;

  @BeforeEach
  public void setUp() {
    pl= new PersonsList();

    person1 = new Person(1, "Revan Abusov", 25, "stalker");
    person2 = new Person(2, "Joe GoldBerg", 30, "stalker");
    pl.add(person1);
    pl.add(person2);
  }
  @Test
  public void testSetAge_Negative() {
    assertThrows(IllegalArgumentException.class, () -> person1.setAge(-1));
  }

  @Test
  public void testFindByName() {
    Person found = pl.findByName("Revan Abusov");
    assertEquals(person1.getName(), found.getName());
  }
  @Test
  public void testFindByName_WrongFormat() {
    assertThrows(IllegalArgumentException.class, () -> pl.findByName("Revan"));
  }


  @Test
  public void testClone() {
    Person cloned = pl.clone(person1);

    assertEquals(person1.getName(), cloned.getName());
    assertEquals(person1.getAge(), cloned.getAge());
    assertEquals(person1.getOccupation(), cloned.getOccupation());
    assertNotEquals(person1.getId(), cloned.getId());
  }
}