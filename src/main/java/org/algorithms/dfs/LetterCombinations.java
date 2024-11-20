package org.algorithms.dfs;

import java.util.HashSet;
import java.util.Set;

public class LetterCombinations {
    public static Set<String> generateCombinations(char[] set) {
        Set<String> result = new HashSet<>();
        generateCombinationsHelper(set, 0, new StringBuilder(), result);
        return result;
    }

    private static void generateCombinationsHelper(char[] set, int index, StringBuilder current, Set<String> result) {
        if (index == set.length) {
            result.add(current.toString());
            return;
        }

        // Include the current character
        current.append(set[index]);
        generateCombinationsHelper(set, index + 1, current, result);

        current.deleteCharAt(current.length() - 1);  // Backtrack
        // Exclude the current character
        generateCombinationsHelper(set, index + 1, current, result);
    }

    public static void main(String[] args) {
        char[] set = {'A', 'B', 'C'};
        Set<String> combinations = generateCombinations(set);

        System.out.println("All possible combinations:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}

