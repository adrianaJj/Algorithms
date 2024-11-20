package org.datastructures.arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the
 * stock at any time. However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
public class BuyAndSellStock2 {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[left] < prices[i]) {
                sum += prices[i] - prices[left];
            }
            left = i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] list = new int[]{7, 1, 5, 3, 6, 4};
        int x = maxProfit(list);
        System.out.println(x);
    }

}
