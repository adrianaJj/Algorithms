package org.algorithms.matrix;


import java.util.*;

public class Sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        int x = Integer.parseInt(scanner.nextLine());
        while (x > 0) {
            String line = scanner.nextLine();
            input.add(line);
            x--;
        }
        // Close the scanner
        scanner.close();

        calc(input);


    }


    private static void calc(List<String> input) {
        int[] map = new int[4];
        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    map[j]++; // Positions are 1-indexed
                }
            }
        }
        int nrSwords = (map[0] + map[1]) / 2 + (map[2] + map[3]) / 2;
        System.out.println(nrSwords +" "+ (map[0] + map[1]) % 2 + " " + (map[2] + map[3]) % 2);
    }

}
