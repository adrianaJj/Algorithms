package org.datastructures.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestSubarray {
    public static List<Integer> getLargestSubarray(List<Integer> arr, int k) {

        return List.of();
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = getLargestSubarray(arr, k);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
