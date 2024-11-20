package org.datastructures.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayofPermutations {

    public static void main(String[] args) {
        int n = 5; // Replace this with the desired size of the array

        int[] arr = generatePermutation(n);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] generatePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // Shuffle the array to create a random permutation
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
}
