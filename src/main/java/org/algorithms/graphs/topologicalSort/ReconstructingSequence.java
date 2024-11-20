package org.algorithms.graphs.topologicalSort;

import java.util.*;
import java.util.stream.Collectors;

public class ReconstructingSequence {

    public static <T> Map<T, Integer> findInDegree(Map<T, List<T>> graph) {
        Map<T, Integer> inDegree = new HashMap<>();
        graph.keySet().forEach(node -> {
            inDegree.put(node, 0);
        });
        graph.entrySet().forEach(entry -> {
            for (T neighbor : entry.getValue()) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        });
        return inDegree;
    }

    public static <T> List<T> topologicalOrder(Map<T, List<T>> graph){
        List<T> res = new ArrayList<>();
        ArrayDeque<T> queue = new ArrayDeque<>();

        return res;
    }

    public static boolean sequenceReconstruction(List<Integer> original, List<List<Integer>> seqs) {
        // WRITE YOUR BRILLIANT CODE HERE
        return false;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> original = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int seqsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> seqs = new ArrayList<>();
        for (int i = 0; i < seqsLength; i++) {
            seqs.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        boolean res = sequenceReconstruction(original, seqs);
        System.out.println(res);
    }
}
