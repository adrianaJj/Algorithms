package org.algorithms.dfs;

import java.util.*;

public class DFSasStack {

        // Function to perform DFS using a stack
        public static void dfs(Map<Integer, List<Integer>> graph, int start) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> visited = new HashSet<>();

            stack.push(start);

            while (!stack.isEmpty()) {
                int currentVertex = stack.pop();
                System.out.print("Visited "+ visited.toString());
                System.out.println("Stack "+ stack.toString() + " currentVertex "+currentVertex);

                if (!visited.contains(currentVertex)) {
                    System.out.println(currentVertex);  // Process the current vertex
                    visited.add(currentVertex);

                    // Explore neighbors and push them onto the stack
                    List<Integer> neighbors = graph.getOrDefault(currentVertex, new ArrayList<>());
                    for (int neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                            System.out.println("Neighbors "+stack.toString());
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            // Example graph represented using an adjacency list
            Map<Integer, List<Integer>> graph = new HashMap<>();
            graph.put(0, Arrays.asList(1, 2));
            graph.put(1, Arrays.asList(3, 4));
            graph.put(2 , Arrays.asList(5));
            graph.put(3, Collections.emptyList());
            graph.put(4, Arrays.asList(6));
            graph.put(5, Collections.emptyList());
            graph.put(6, Collections.emptyList());

            // Starting DFS from vertex 0
            dfs(graph, 0);
        }
    }


