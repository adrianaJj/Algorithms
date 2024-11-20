package org.algorithms;

public class FindMaxConsecutiveOfOne {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
            }else{
                max = Math.max(max, count);
                count=0;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Hello World!");

        int[] nums = new int[]{0,1};
        //int[] nums = new int[]{1,1,0,1,1,1};
        int max = findMaxConsecutiveOnes(nums);
        System.out.println("Max el is: " + max);
    }

}
