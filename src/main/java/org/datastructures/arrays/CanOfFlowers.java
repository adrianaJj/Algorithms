package org.datastructures.arrays;


/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means
 * not empty, and an integer n, return true if n new flowers can be planted in the flowerbed
 * without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1  [0,1,0,0,1]
 * Output: true
 */
public class CanOfFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if (n <= 0) {
            return true;
        }
        if (size <= 1) {
            if (flowerbed[0] == 1) return false;
            else if (n <= 1) return true;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (flowerbed[size - 1] == 0 && flowerbed[size - 2] == 0) {
            flowerbed[size - 1] = 1;
            n--;
        }
        for (int i = 1; i < size - 1; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (n <= 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,1};
        boolean out = canPlaceFlowers(flowerbed, 1);
        System.out.println(out);
    }
}
