package org.datastructures.arrays;

public class ProductofArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int prod = 1;
        out[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
        }
        for(int j = nums.length-1 ; j>= 0; j--){
            out[j] = prod/nums[j];
        }
        return out;
    }

    public static void main(String[] args) {
        int[] out = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(out.toString());
    }
}
