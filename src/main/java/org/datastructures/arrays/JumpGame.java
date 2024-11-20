package org.datastructures.arrays;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {

        return false;
    }

    public static void main(String[] args) {
        int[] list = new int[]{7, 1, 5, 3, 6, 4};
        boolean x = canJump(list);
        System.out.println(x);
    }
}
