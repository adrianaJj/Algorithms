package org.algorithms.twopointers.slidingWindow;

import java.util.*;
import java.util.stream.Collectors;

public class SubarraySum {
    public static int subarraySumFixed(List<Integer> nums, int k) {
        int slide = 0;
        int max = 0;
        for (int i = 0; i < nums.size() - k; i++) {
            slide = i;
            int sum = 0;
            int window = slide+k;
            while (slide < window) {
                sum = sum + nums.get(slide);
                slide++;
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumFixed(nums, k);
        System.out.println(res);
    }
}
