package org.datastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] wordsArray = s.trim().split("\\s+");
        List<String> wordsList = new ArrayList<String>(Arrays.asList(wordsArray));
        Collections.reverse(wordsList);
        return String.join(" ", wordsList);
    }
    public static void main(String[] args) {
        String out = reverseWords(" hello  world  ");
        System.out.println(out);
    }
}
