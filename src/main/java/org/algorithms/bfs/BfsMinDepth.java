package org.algorithms.bfs;

import java.util.*;
import java.util.function.Function;

public class BfsMinDepth {

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

    public static int binaryTreeMinDepth(Node<Integer> root) {
        if (root == null) return 0;
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        int min_depth = Integer.MAX_VALUE;
        int depth = -1;
        while (queue.size() > 0) {
            depth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                if (node.left == null && node.right == null) {
                   return depth;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }

        }
        return min_depth;
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
        int res = binaryTreeMinDepth(root);
        System.out.println(res);
    }
}
