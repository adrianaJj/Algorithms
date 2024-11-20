package org.algorithms.bfs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Bfs_ZigZag {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        boolean levelCount = true;
        while (queue.size() > 0) {
            int n = queue.size();
            ArrayDeque<Integer> newLevel = new ArrayDeque<>();
            for (int i = 0; i <n; i++) {
                Node<Integer> node = queue.pop();
                if (levelCount) {
                    newLevel.add(node.val);
                } else {
                    newLevel.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            res.add((Arrays.asList(newLevel.toArray(new Integer[0]))));
            levelCount = !levelCount;
        }

        return res;
    }


    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<List<Integer>> res = zigZagTraversal(root);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}