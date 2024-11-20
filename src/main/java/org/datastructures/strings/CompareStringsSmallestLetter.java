package org.datastructures.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A string is defined to be "strictly smaller" than another string when the number of occurrences of the lexicographically
 * smallest character in the string is less than that of the other. For example, "abcd" is strictly smaller than "aaa" because
 * the smallest character in "abcd", "a", appears 1 time, whereas the smallest character in "aaa", "a", appears 3 times.
 * In another example, "d" is strictly smaller than "ff" because the smallest character in "d", 'd', appears 1 time, and the
 * smallest character in "ff", 'f', appears 2 times.
 * Given a list of strings str1 with m elements, and another list of strings str2 with n elements, return an array A of n
 * integers. For 0 <= i < n, A[i] is the number of strings in str1 that are strictly smaller than the comparison i-th string
 * in str2. Focus on correctness instead of performance in your solution.
 * Example 1:
 * Input:
 * str1 = "abcd aabc bd"
 * str2 = "aaa aa"
 * Output: [3, 2]
 * Explanation:
 * All the strings in str1 are strictly smaller than "aaa", and strings "abcd" and "bd" are strictly smaller than "aa".
 */
public class CompareStringsSmallestLetter {

    public static List<Integer> compareStrings(List<String> str1, List<String> str2) {
        List<Integer> out = new ArrayList<>();
        for (String st2 : str2) {
            int str2Lex = lexicIndex(st2);
            int sum = 0;
            for (String st1 : str1) {
                if (str2Lex > lexicIndex(st1)) {
                    sum++;
                }
            }
            out.add(sum);
        }

        return out;
    }


    private static int lexicIndex(String str) {
        int minCh = Character.MAX_VALUE;
        int minCount = 0;

        for (char ch : str.toCharArray()) {
            if (ch < minCh) {
                minCount = 1;
                minCh = ch;
            } else if (ch == minCh) {
                minCount++;
            }
        }
        return minCount;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> str1 = splitWords(scanner.nextLine());
        List<String> str2 = splitWords(scanner.nextLine());
        scanner.close();
        List<Integer> res = compareStrings(str1, str2);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
