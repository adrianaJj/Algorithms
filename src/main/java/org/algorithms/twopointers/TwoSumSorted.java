package org.algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given an array of integers sorted in ascending order, find two numbers that add up to a given target.
 * Return the indices of the two numbers in ascending order. You can assume elements in the array are
 * unique and there is only one solution. Do this in O(n) time and with constant auxiliary space.
 */
class TwoSumSorted {
    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int fast = arr.size()-1;
        List<Integer> res =  new ArrayList<>();
        for (int slow = 0; slow< fast; slow++)
        {
            if(arr.get(slow)+arr.get(fast) == target){
                res.add(slow);
                res.add(fast);
                return res;
            }
        }
            return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = twoSumSorted(arr, target);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}