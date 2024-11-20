package org.leetcode.top75;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductArrayExceptSelf {

    // calculate the product of all el in array except self
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int size = nums.length;
        int left = 1;
        for (int i = 0; i < size; i++) {
            result[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] out = productExceptSelf(nums);
        System.out.println(Arrays.toString(out));
    }
}
