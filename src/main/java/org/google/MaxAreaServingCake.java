package org.google;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxAreaServingCake {
    public static double getMaxPizzaSliceSize(int[] radii, int guests) {

        double minSliceSize = Double.MAX_VALUE;
        double maxSliceSize = Double.MIN_VALUE;

        for (int i = 0; i < radii.length; i++) {
            minSliceSize = Math.min(3.14 * radii[i] * radii[i], minSliceSize);  // min between minArea
            maxSliceSize = Math.max(3.14 * radii[i] * radii[i], maxSliceSize);
        }
        minSliceSize = minSliceSize / guests;
        while (minSliceSize < maxSliceSize) {
            double mid = (minSliceSize + maxSliceSize) / 2;
            int g = getGuests(radii, mid);
            if (g <= guests) {
                minSliceSize = mid + 1;
            } else {
                maxSliceSize = mid - 1;
            }

        }
        return minSliceSize;
    }

    public static int getGuests(int[] radii, double mid) {
        int k = 0;
        for (int radius : radii) {
            k += (int) (3.14 * radius * radius) / mid;
        }
        return k;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> radii = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int guests = Integer.parseInt(scanner.nextLine());
        scanner.close();
       // double res = getMaxPizzaSliceSize(radii, guests);
       // System.out.printf("%.4f\n", res);
    }
}
