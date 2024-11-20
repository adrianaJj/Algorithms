package org.algorithms.twopointers;

import java.util.Arrays;

public class MergedTwoArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int out = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums1[i] <= nums2[j]) {
                nums1[out] = nums2[j];
                j--;
            } else {
                nums1[out] = nums1[i];
                i--;
            }
            out--;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println("Max el is: " + Arrays.toString(nums1));
    }
}
