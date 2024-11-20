package org.datastructures.strings;

public class RotationalCipher {

    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder str = new StringBuilder();
        int ordA = 'A';
        int orda = 'a';
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                str.append((Character.getNumericValue(ch) + rotationFactor) % 10);
            } else if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    // there are 26 alphabetic characters
                    int temp = (ch - ordA + rotationFactor) % 26;
                    str.append((char) (ordA + temp));
                } else {
                    int temp = (ch - orda + rotationFactor) % 26;
                    str.append((char) (orda + temp));
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}
