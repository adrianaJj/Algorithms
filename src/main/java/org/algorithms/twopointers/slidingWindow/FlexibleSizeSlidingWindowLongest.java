package org.algorithms.twopointers.slidingWindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * find the length of the longest subarray with sum smaller than or equal to a target
 * ex: Given input nums = [1, 6, 3, 1, 2, 4, 5] and target = 10, then the longest subarray
 * that does not exceed 10 is [3, 1, 2, 4], so the output is 4 (length of [3, 1, 2, 4]).
 */

public class FlexibleSizeSlidingWindowLongest {
    public static int subarraySumLongest(List<Integer> nums, int target) {
        int windowSum = 0;
        int windowMaxSize = 0;
        int left = 0;
        for (int i = 0; i < nums.size(); i++) {
            windowSum = windowSum + nums.get(i);
            while (windowSum > target) {
                windowSum = windowSum - nums.get(left);
                left++;
            }
            windowMaxSize = Math.max(i - left + 1, windowMaxSize);
        }

        return windowMaxSize;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumLongest(nums, target);
        System.out.println(res);
    }
}
