package org.jpmorgan;

public class RotateString {
    static String leftrotate(String str1, int n) {

        // creating extended string and index for new
        // rotated string
        String temp = str1 + str1;
        int l1 = str1.length();

        String Lfirst = temp.substring(n, n + l1);

        // now returning  string
        return Lfirst;
    }

    // Rotating the string using extended string
    static String rightrotate(String str1, int n) {
        return leftrotate(str1, str1.length() - n);
    }

}
