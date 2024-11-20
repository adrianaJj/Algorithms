package org.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductOfListExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] out = new int[nums.length];
        Arrays.fill(out, 1);
        for (int i = 0; i < nums.length; i++) {
            out[i] *= prod;
            prod = prod * nums[i];
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= prod;
            prod *= nums[i];
        }

        return out;
    }



    public static void main(String[] args) {
        int[] list = new int[]{2, 3, 5, 1, 3};
        int[] out = productExceptSelf(list);
        System.out.println(Arrays.asList(out).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
