package org.leetcode.hard;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 */
public class MedianOfTwoArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int i = 0, j = 0, x = 0;
        int[] merged = new int[size1 + size2];

        while (i < size1 && j < size2) {
            if (nums1[i] <= nums2[j]) {
                merged[x++] = nums1[i++];
            } else if (nums1[i] >= nums2[j]) {
                merged[x++] = nums2[j++];
            }
        }

        while (i < size1) {
            merged[x++] = nums1[i++];
        }
        while (j < size2) {
            merged[x++] = nums2[j++];
        }
        double med = 0.0;
        int mid = merged.length / 2;
        if (merged.length % 2 == 0) {
            med = (double) ((merged[mid - 1] + merged[mid]) / 2.0);
        } else {
            med = merged[mid];
        }
        return med;
    }


    public static void main(String[] args) {
        int[] n1 = new int[]{0, 0, 0, 0, 0};
        int[] n2 = new int[]{-1, 0, 0, 0, 0, 0, 1};

        double i = findMedianSortedArrays(n1, n2);
        System.out.println("output:  " + i);
    }
}
