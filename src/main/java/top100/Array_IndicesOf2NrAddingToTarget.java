package top100;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class Array_IndicesOf2NrAddingToTarget {

    public static int[] sumOfTarget(int target, int[] array) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (res.containsKey(target - array[i]))
            {
                return new int[]{res.get(target - array[i]), i};
            }
            res.put(array[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }
}
