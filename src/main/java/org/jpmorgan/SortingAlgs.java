package org.jpmorgan;

import java.util.*;
import java.util.stream.Collectors;

public class SortingAlgs {

    // sort an array of numbers where max nr is 101
    public static List<Integer> mergeSort(List<Integer> unsortedList, int start, int end) {
        if (end - start <= 1) {
            return unsortedList.subList(start, end);
        }

        int mid = (end + start) / 2;
        List<Integer> leftList = mergeSort(unsortedList, start, mid);
        List<Integer> rightList = mergeSort(unsortedList, mid, end);

        ArrayList<Integer> result = new ArrayList<>();
        int leftPointer = 0;
        int rightPointer = 0;

        //merge left and right lists
        while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
            if (leftPointer == leftList.size()) {
                result.add(rightList.get(rightPointer));
                rightPointer++;
            } else if (rightPointer == rightList.size()) {
                result.add(leftList.get(leftPointer));
                leftPointer++;
            } else if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {
                result.add(leftList.get(leftPointer));
                leftPointer++;
            } else {
                result.add(rightList.get(rightPointer));
                rightPointer++;
            }
        }
        return result;
    }

    public static void quickSort(List<Integer> unsortedList, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int pivot = unsortedList.get(end - 1);
        int startP = start;
        int endP = end - 1;
        // Partitioning process
        while (startP < endP) {
            // Find the next element from the left that is larger than the pivot
            while (unsortedList.get(startP) < pivot && startP < endP) {
                startP++;
            }
            // Find the next element from the right that is smaller than or equal to the pivot
            while (unsortedList.get(endP) >= pivot && startP < endP) {
                endP--;
            }
            // Swap if pointers haven't met
            if (startP != endP) {
                int temp = unsortedList.get(startP);
                unsortedList.set(startP, unsortedList.get(endP));
                unsortedList.set(endP, temp);
            }
        }

        // Place pivot in its final position
        int temp = unsortedList.get(startP);
        unsortedList.set(startP, unsortedList.get(end - 1));
        unsortedList.set(end - 1, temp);

        // Sort left and right of the pivot
        quickSort(unsortedList, start, startP);
        quickSort(unsortedList, startP + 1, end);

    }

    public static void bubbleSort(int[] unsortedList) {
        int temp;
        boolean swapped;
        for (int i = 0; i < unsortedList.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < unsortedList.length - i - 1; j++) {
                if (unsortedList[j] > unsortedList[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = unsortedList[j];
                    unsortedList[j] = unsortedList[j + 1];
                    unsortedList[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    public static List<Integer> mergeSortList(List<Integer> unsortedList) {
        return mergeSort(unsortedList, 0, unsortedList.size());
    }

    public static List<Integer> sortList(List<Integer> unsortedList) {
        quickSort(unsortedList, 0, unsortedList.size());
        return unsortedList;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> unsortedList = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = sortList(unsortedList);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

}
