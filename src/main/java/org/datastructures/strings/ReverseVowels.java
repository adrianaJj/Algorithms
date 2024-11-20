package org.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 */
public class ReverseVowels {
    public static List<Character> vowels = new ArrayList<>();

    private static void populateVowels() {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public static String reverseVowels(String s) {
        if (s.length() <= 1) return s;
        int left = 0;
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(ch[left])) {
                left++;
            }
            while (left < right && !vowels.contains(ch[right])) {
                right--;
            }

            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;

        }

        return new String(ch);
    }

    public static void main(String[] args) {
        populateVowels();
        String out = reverseVowels("hello");
        System.out.println(out);
    }
}
