package org.algorithms.twopointers.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnagramsInString {
    public static List<Integer> findAllAnagrams(String original, String check) {

        int sizeC = check.length();
        int sizeO = original.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (sizeO < sizeC) return res;

        // number of each character that will exist in each substring searched
        char[] window = new char[26];
        // number of each character that exists in check string
        char[] checkA = new char[26];

        // search in first x elements of the string if it is an anagram of the check string
        for (int i = 0; i < sizeC; i++) {
            window[original.charAt(i) - 'a']++;
            checkA[check.charAt(i) - 'a']++;
        }
        if (Arrays.equals(window, checkA))
            res.add(0);
        for (int j = sizeC; j < sizeO ; j++) {
            int l = j - sizeC;
            window[original.charAt(l) - 'a']--;
            window[original.charAt(j) - 'a']++;
            if (Arrays.equals(window, checkA)) res.add(j - sizeC + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        String check = scanner.nextLine();
        scanner.close();
        List<Integer> res = findAllAnagrams(original, check);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
