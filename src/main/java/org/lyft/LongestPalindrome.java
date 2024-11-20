package org.lyft;

import java.util.HashMap;

/**
 * Given a string, how would you find the longest palindrome.
 * In this problem, we're given a string s containing a mix of lowercase and uppercase letters.
 * Our task is to determine the maximum length of a palindrome that can be created using the letters
 * from the string. It's important to note that case matters here; 'A' and 'a' are treated as different
 * characters, which means a string like "Aa" wouldn't count as a palindrome.
 *
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right) + 1, 1));
            if(map.get(s.charAt(right)) %2 == 0){
                    result+= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 4, 6, 8, 3, 10};
        int i = longestPalindrome("");
        System.out.println("output:  " + i);
    }
}
