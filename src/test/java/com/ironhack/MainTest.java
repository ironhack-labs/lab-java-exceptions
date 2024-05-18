package com.ironhack;

public class MainTest {
    public static void main(String[] args) {
        PersonsListTest test = new PersonsListTest();
        test.testFindByName();
        test.testFindByNameThrowsError();
        test.testClone();
    }
}