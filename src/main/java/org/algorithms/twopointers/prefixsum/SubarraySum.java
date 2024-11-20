package org.algorithms.twopointers.prefixsum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of integers and an integer target, find a subarray that sums to target and return the start and end indices
 * of the subarray.
 * Input: arr: 1 -20 -3 30 5 4 target: 7
 * Output: 1 4
 * Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right exclusive).
 */
public class SubarraySum {
    public static int subarraySumTotal(List<Integer> arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int totalNrSubarray=0;
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i);
            int c = sum - target;
            if(map.containsKey(c)){
                totalNrSubarray++;
            }
            map.put(sum,i);

        }

        return totalNrSubarray;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumTotal(arr, target);
        System.out.println(res);
    }


}
