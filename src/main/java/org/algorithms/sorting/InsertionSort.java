package org.algorithms.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertionSort {
    public static List<Integer> insertionSort(List<Integer> unsortedList) {

        for (int i = 1; i < unsortedList.size(); i++) {
            int currentEl = i;
            while (currentEl > 0 && unsortedList.get(i) < unsortedList.get(i - 1)) {
                int temp = unsortedList.get(i - 1);
                unsortedList.set(i - 1, unsortedList.get(i));
                unsortedList.set(i, temp);
                currentEl--;
            }
        }
        return unsortedList;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> unsortedList = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = insertionSort(unsortedList);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
