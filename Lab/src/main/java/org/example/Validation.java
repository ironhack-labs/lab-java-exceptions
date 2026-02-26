package org.example;

public  abstract class Validation {
    public boolean isValidName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return true;
        }
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length < 2) {
            return true;
        }
        String nameRegex = "^[A-Za-z'-]+$";
        for (String part : parts) {
            if (!part.matches(nameRegex)) {
                return true;
            }
        }
        return false;
    }
}
