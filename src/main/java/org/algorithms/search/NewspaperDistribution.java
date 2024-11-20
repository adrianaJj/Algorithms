package org.algorithms.search;

public class NewspaperDistribution {

    public static int minimizeReadTime(int[] newspaperTimes, int numWorkers) {
        int totalNewspapers = newspaperTimes.length;

        if (numWorkers > totalNewspapers) {
            // More workers than newspapers, each worker can get a separate newspaper
            return getMaxTime(newspaperTimes);
        }

        int left = getMaxTime(newspaperTimes);
        int right = getSum(newspaperTimes);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isValidDistribution(newspaperTimes, numWorkers, mid)) {
                // If the current maximum time is valid, try to minimize it further
                right = mid;
            } else {
                // If not valid, increase the maximum time
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isValidDistribution(int[] newspaperTimes, int numWorkers, int maxTime) {
        int workersNeeded = 1;
        int currentReadTime = 0;

        for (int time : newspaperTimes) {
            currentReadTime += time;

            if (currentReadTime > maxTime) {
                // Assign the current pile to the next worker
                workersNeeded++;
                currentReadTime = time;
            }
        }

        // edge case to check if we needed an extra coworker at the end
        if (currentReadTime != 0) {
            numWorkers++;
        }

        return workersNeeded <= numWorkers;
    }



    private static int getMaxTime(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] newspaperTimes = {3, 2, 1, 4, 5, 2};
        int numWorkers = 3;

        int minTime = minimizeReadTime(newspaperTimes, numWorkers);

        System.out.println("Minimum amount of time: " + minTime);
    }
}