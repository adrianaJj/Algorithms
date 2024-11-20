package org.algorithms.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class DistanceBetweenTwoPOints {
    private static List<Integer> getNeighbors(List<List<Integer>> graph, int node) {
        return graph.get(node);
    }

    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(a);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(a);
        int level = 0;
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int node = queue.pop();
                if (node == b) return level;
                for (int neighbour : getNeighbors(graph, node)) {
                    if (visited.contains(neighbour)) continue;
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
            level++;
        }
        return level;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int graphLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < graphLength; i++) {
            graph.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = shortestPath(graph, a, b);
        System.out.println(res);
    }
}
