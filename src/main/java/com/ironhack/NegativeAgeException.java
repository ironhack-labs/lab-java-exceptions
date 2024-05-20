package com.ironhack;

public class NegativeAgeException extends RuntimeException {

    public NegativeAgeException() {
        super("There is a problem with the age !");
    }

    public NegativeAgeException(String message) {
        super(message);
    }
}
