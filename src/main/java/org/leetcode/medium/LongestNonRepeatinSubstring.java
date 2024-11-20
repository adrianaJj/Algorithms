package org.leetcode.medium;

import java.util.HashMap;

public class LongestNonRepeatinSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcbcadb");
        System.out.println("output:  " + i);
    }
}
