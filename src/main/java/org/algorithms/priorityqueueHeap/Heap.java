package org.algorithms.priorityqueueHeap;

import java.util.*;
import java.util.stream.Collectors;

public class Heap {
    public static List<Integer> heapTop3(List<Integer> arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : arr) {
            heap.add(x);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            res.add(heap.poll());
        }
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = heapTop3(arr);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

}
