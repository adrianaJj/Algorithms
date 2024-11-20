package org.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CombinationsofAandB {

    public static void main(String[] args) {
        char[] elements = {'a', 'b', 'c'};
        List<List<Character>> result = generateCombinations(elements);

        // Print the result
        for (List<Character> combination : result) {
            System.out.println(combination);
        }
    }

    private static List<List<Character>> generateCombinations(char[] elements) {
        List<List<Character>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), elements, 0);
        return result;
    }

    private static void backtrack(List<List<Character>> result, List<Character> current, char[] elements, int start) {
        if (current.size() > 0) {
            result.add(new ArrayList<>(current));
        }

        for (int i = start; i < elements.length; i++) {
            // Choose
            current.add(elements[i]);

            // Explore
            backtrack(result, current, elements, i + 1);

            // Unchoose (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
