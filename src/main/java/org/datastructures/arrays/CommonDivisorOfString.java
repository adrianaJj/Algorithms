package org.datastructures.arrays;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
 * (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * Example 1: *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 */
public class CommonDivisorOfString {

    public String gcdOfStrings(String str1, String str2) {
        int size1 = str1.length();
        int size2 = str2.length();
        if (!(str1 + str2).equals(str2 + str1))
            return "";

        int divisor = gc(size1, size2);

        return str1.substring(0,divisor);

    }

    public static int gc(int size1, int size2){
        return size2 == 0 ? size1 : gc(size2, size1 % size2);
    }

    public static void main(String[] args) {

    }
}
