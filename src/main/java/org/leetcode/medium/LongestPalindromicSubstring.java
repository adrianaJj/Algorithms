package org.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a string s, return the longest
 * palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {


    private static int maxLength = 0;
    private static int start = 0;

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);     // Check for odd-length palindrome
            extendPalindrome(s, i, i + 1); // Check for even-length palindrome
            if (maxLength == s.length())
                return s.substring(start, start + maxLength);
        }
        return s.substring(start, start + maxLength);
    }

    private static void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Calculate length of palindrome and update start and maxLength
        int length = right - left - 1;
        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }


    public static void main(String[] args) {
        String i = longestPalindrome("abcbcadb");
        System.out.println("output:  " + i);
    }
}
