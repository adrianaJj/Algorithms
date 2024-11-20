package org.algorithms;


import java.util.ArrayList;
import java.util.List;

public class CombinationGenerator {

    public static void main(String[] args) {
        List<Integer> elements = List.of(1, 2, 3); // Replace with your elements
        int r = 2; // Replace with the desired combination size

        List<List<Integer>> combinations = generateCombinations(elements, r);

        // Display the generated combinations
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> generateCombinations(List<Integer> elements, int r) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinationsHelper(elements, r, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(List<Integer> elements, int r, int start,
                                                   List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (r == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < elements.size(); i++) {
            currentCombination.add(elements.get(i));
            generateCombinationsHelper(elements, r - 1, i + 1, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

