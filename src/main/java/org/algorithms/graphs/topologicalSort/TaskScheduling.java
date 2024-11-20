package org.algorithms.graphs.topologicalSort;


import java.util.*;

/**
 * For this problem, given a list of tasks and a list of requirements, compute a sequence of tasks that can be performed,
 * such that we complete every task once while satisfying all the requirements.
 * Each requirement will be in the form of a list [a, b], where task a needs to be completed first before task b can be completed,
 * There is guaranteed to be a solution.
 * <p>
 * Examples
 * Input:
 * tasks = ["a", "b", "c", "d"]
 * requirements = [["a", "b"], ["c", "b"], ["b", "d"]]
 * Output: ["a", "c", "b", "d"]
 */
public class TaskScheduling {

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

    public static <T> List<T> topologicalSort(Map<T, List<T>> graph) {
        List<T> res = new ArrayList<>();
        ArrayDeque<T> queue = new ArrayDeque<>();
        Map<T, Integer> inDegree = findInDegree(graph);
        inDegree.entrySet().forEach(entry -> {
            if (entry.getValue() == 0)
                queue.add(entry.getKey());
        });
        while (!queue.isEmpty()) {
            T node = queue.poll();
            res.add(node);
            for (T neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return (graph.size() == res.size()) ? res : null;
    }

    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String task : tasks) {
            graph.put(task, new ArrayList<>());
        }
        for (List<String> req : requirements) {
            graph.get(req.get(0)).add(req.get(1));
        }
        return topologicalSort(graph);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = splitWords(scanner.nextLine());
        int requirementsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> requirements = new ArrayList<>();
        for (int i = 0; i < requirementsLength; i++) {
            requirements.add(splitWords(scanner.nextLine()));
        }
        scanner.close();
        List<String> res = taskScheduling(tasks, requirements);
        if (res.size() != tasks.size()) {
            System.out.println("output size " + res.size() + " does not match input size " + tasks.size());
            return;
        }
        HashMap<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < res.size(); i++) {
            indices.put(res.get(i), i);
        }
        for (List<String> req : requirements) {
            for (String task : req) {
                if (!indices.containsKey(task)) {
                    System.out.println("'" + task + "' is not in output");
                    return;
                }
            }
            String a = req.get(0);
            String b = req.get(1);
            if (indices.get(a) >= indices.get(b)) {
                System.out.println("'" + a + "' is not before '" + b + "'");
                return;
            }
        }
        System.out.println("ok");
    }
}
