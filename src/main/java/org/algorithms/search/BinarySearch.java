package org.algorithms.search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySearch {
    public static int binarySearch(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left = 0;
        int right = arr.size() -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr.get(mid)== target){
                return mid;
            }
            if(arr.get(mid)<target){
                left = mid+1;
            } else {
                right = mid+1;
            }
        }
        return 0;
    }


    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = binarySearch(arr, target);
        System.out.println(res);
    }
}
