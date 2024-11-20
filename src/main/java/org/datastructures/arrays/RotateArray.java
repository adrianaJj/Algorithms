package org.datastructures.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(0, nums.length - 1, nums);
        reverse(0, k-1, nums);
        reverse(k, nums.length-1, nums);
    }

    private static void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        rotate(flowerbed, 3);
         System.out.println(Arrays.toString(flowerbed));
    }
}
