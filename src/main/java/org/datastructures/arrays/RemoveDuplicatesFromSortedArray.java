package org.datastructures.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {

        int len = 0;
        for(int i=0; i< nums.length; i++){
            if(len == 0 || nums[i] != nums[len-1]){
                nums[len++]=nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,1,2};
        int out = removeDuplicates(flowerbed);
        System.out.println(out);
    }
}
