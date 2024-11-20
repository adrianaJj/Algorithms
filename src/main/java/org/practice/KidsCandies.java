package org.practice;

import java.util.ArrayList;
import java.util.List;

public class KidsCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> output = new ArrayList<>();
        int n = candies.length;
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i])
                max = candies[i];
        }

        for (int j = 0; j < candies.length; j++) {
            if (candies[j] + extraCandies >= max) {
                output.add(true);
            } else {
                output.add(false);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        List<Boolean> str = kidsWithCandies(candies, 3);
        System.out.println(" Merge " + str.toString());
    }
}
