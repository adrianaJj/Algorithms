package org.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubsequence {
    public static int lengthOfLIS(List<Integer> nums) {
        int n = nums.size();
        final int INFINITY = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INFINITY);
        dp[0] = -INFINITY;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[j - 1] < nums.get(i) && nums.get(i) < dp[j]) {
                    dp[j] = nums.get(i);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] < INFINITY) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> n1 = new ArrayList<>();
        n1.add(5);
        n1.add(8);
        n1.add(2);
        n1.add(3);
        n1.add(7);
        n1.add(9);
        n1.add(1);
        n1.add(8);
        n1.add(9);
        n1.add(10);
        int i = lengthOfLIS(n1);
        System.out.println("output:  " + i);
    }
}
