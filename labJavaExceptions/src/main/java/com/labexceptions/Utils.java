package com.labexceptions;

public class Utils {

    public static void checkName (String string) {
        int minimumWords = 2;
        String[] words = string.split("\\s+");
        int wordCount = words.length;
        if (wordCount < minimumWords) {
            throw new IllegalArgumentException("You have to  write your name and surname");
        }
    }

}
