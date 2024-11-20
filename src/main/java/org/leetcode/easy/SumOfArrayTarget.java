package org.leetcode.easy;

import java.util.Arrays;

public class SumOfArrayTarget {
    public static int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        int left = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int n = i+1;
            while (n < size) {
                int sum = nums[i] + nums[n];
                if (sum == target) {
                    out[0] = i;
                    out[1] = n;
                    return out;
                }
                n++;
            }
        }

        return out;
    }

    public static void main(String[] args) {
        int[] in = new int[]{3, 2, 4};
        int[] out = twoSum(in, 6);
        System.out.println(Arrays.toString(out));
    }
}
