package org.lyft;

import java.util.*;

/**
 * For a given array containing positive integers, write a code to return the sum of the elements of the array.
 */
public class SumOfEl {

    public static int sumofel(int[] list) {
        int l = 0;
        int r = list.length - 1;
        int sum = 0;
        while (l < r) {
            sum += list[l] + list[r];
            l++;
            r--;
        }
        return sum;
    }

    /**
     * For a given array of size N, write a code to print the reverse of the array.
     *
     * @return
     */
    public static Integer[] reverseOfArray(Integer[] arr) {
        Collections.reverse(Arrays.asList(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 4, 6, 8, 3, 10};
        int i = sumofel(n1);
        System.out.println("output:  " + i);

        Integer[] n2 = new Integer[]{1, 4, 6, 8, 3, 10};
        Integer[] arr = reverseOfArray(n2);
        System.out.println("Reversed "+Arrays.toString(arr));
    }
}
