package org.algorithms.twopointers.slidingWindow;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Find the length of the longest substring of a given string without repeating characters.
 * Input: abccabcabcc
 * Output: 3
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int longestSubstring = 0;
        int left=0;
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0)+1);
            while (window.get(s.charAt(i)) > 1) {
                window.put(s.charAt(left), window.get(s.charAt(left))-1);
                left++;
            }
            longestSubstring = Math.max(i - left + 1, longestSubstring);
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int res = longestSubstringWithoutRepeatingCharacters(s);
        System.out.println(res);
    }
}
