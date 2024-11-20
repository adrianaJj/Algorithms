package org.algorithms.twopointers.slidingWindow;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlexibleSizeSlidingWindowShortest {

    public static int subarraySumShortest(List<Integer> nums, int target) {
        int windowSum = 0;
        int shortestPath = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.size(); i++) {
            windowSum = windowSum + nums.get(i);
            while (windowSum >= target) {
                shortestPath = Math.min(shortestPath, i - left + 1);
                windowSum = windowSum - nums.get(left);
                left++;
            }
        }
        return shortestPath;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumShortest(nums, target);
        System.out.println(res);
    }
}
