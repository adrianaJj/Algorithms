package org.datastructures.arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left < 2 || nums[i] != nums[left - 2]) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 1, 1, 2, 2, 3};
        int out = removeDuplicates(flowerbed);
        System.out.println(out);
    }
}
