package org.leetcode.medium;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want
 * to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR" *
 * Write the code that will take a string and make this conversion given a number of rows: *
 * string convert(string s, int numRows); *
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 */

public class ZigzagMatrix {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int diff = 2 * (numRows - 1);
        int diagonalDiff = diff;
        int secondIndex;
        int index;
        for (int i = 0; i < numRows; i++) {
            index = i;

            while (index < n) {
                answer.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    diagonalDiff = diff - 2 * i;
                    secondIndex = index + diagonalDiff;

                    if (secondIndex < n) {
                        answer.append(s.charAt(secondIndex));
                    }
                }
                index += diff;
            }
        }

        return answer.toString();

    }

    public static String convertt(String inputString, int numRows) {
        // If numRows is 1, no pattern is required, so return the string as it is.
        if (numRows == 1) {
            return inputString;
        }

        StringBuilder convertedStringBuilder = new StringBuilder();
        int cycleLength = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            int interval = (row == numRows - 1) ? cycleLength : 2 * (numRows - row - 1);
            int index = row;

            while (index < inputString.length()) {
                convertedStringBuilder.append(inputString.charAt(index));
                index += interval;
                interval = (interval == cycleLength || interval == 0) ? cycleLength : cycleLength - interval;
            }
        }

        return convertedStringBuilder.toString();
    }

    public static void main(String[] args) {

        String i = convertt("PAYPALISHIRING", 4);
        System.out.println("output:  " + i);
    }

}
