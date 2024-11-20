package org.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IncreasingTripleSeq {
    public static boolean increasingTriplet(int[] nums) {
        int left = 0;
        for(int right= 2; right < nums.length; right++){
            if(nums[left] < nums[right-1] && nums[right-1] < nums[right]){
                return true;
            }
            left ++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] list = new int[]{20,100,10,12,5,13};
        boolean t = increasingTriplet(list);
        System.out.println(t);
    }
}
