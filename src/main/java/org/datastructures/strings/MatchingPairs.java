package org.datastructures.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
 * Note: This means you must swap two characters at different indices.
 * Signature
 * int matchingPairs(String s, String t)
 * Input
 * s and t are strings of length N
 * N is between 2 and 1,000,000
 * Output
 * Return an integer denoting the maximum number of matching pairs
 * Example 1
 * s = "abcd"
 * t = "adcb"
 * output = 4
 * Explanation:
 * Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
 * Therefore, the number of matching pairs of s and t will be 4.
 * Example 2
 * s = "mno"
 * t = "mno"
 * output = 1
 * Explanation:
 * Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
 */
public class MatchingPairs {


    int matchingPairs(String s, String t) {
        int diff = 0;
        //Character.compare(s,t);
        int m = StringUtils.compare(s, t);
        if (m == 0) {
            diff = 2;
        } else {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < t.length(); j++) {
                    // Swap characters at indices i and j in string s
                 //   String swapped = swapCharacters(s, i, j);
                    // Count the matching pairs after the swap
                //    int matchingPairs = countMatchingPairs(s, t);
                    // Update the maximum matching pairs
                //    diff = Math.max(diff, matchingPairs);
                }
            }
        }

        return diff;
    }

    int matchingPairs2(String s, String t) {
        Map<Character, Character> m = new HashMap<>(); // k = letter from t, v = letter from s
        int count = 0;
        int swappable_locations = 0; // track potential swaps
        boolean swapped = false; // track if a perfect swap is done

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            } else if (!swapped && m.containsKey(s.charAt(i)) && m.get(s.charAt(i)) == t.charAt(i)) {
                // 2 matching swaps
                m.remove(s.charAt(i));
                count += 2;
                swapped = true;
            } else if (!swapped && m.containsKey(s.charAt(i))) {
                // tracking at least one swap
                swappable_locations++;
            } else {
                m.put(t.charAt(i), s.charAt(i));
            }
        }

        // edge cases
        if (!swapped) {
            if (swappable_locations == 1) count++; // abyz vs abzt
            else count -= 2; // a swap is req'd regardless
        }

        return count;
    }

    private static String s(int N, String C){
       return C.replace('A', 'X').replace('B', 'A').replace('X', 'B');
  //      return C;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
       /* String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 6;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);*/

        String x = "ABA";
        String out1 = s(3,x);
        System.out.println("x "+ x + " out1 "+ out1);
        String y= "BBBBB";
        String out2 = s(5,y);
        System.out.println("y "+ y + " out2 "+ out2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
