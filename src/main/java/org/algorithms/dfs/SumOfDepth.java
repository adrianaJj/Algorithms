package org.algorithms.dfs;

import org.algorithms.backtracking.BacktrackingAlg;

import java.util.*;
import java.util.function.Function;

public class SumOfDepth {

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

    public static List<Integer> dfsSum(Node<Integer> root, List<Integer> res, int sum) {
        if (root == null) return null;
        sum += root.val;
        if (root.left == null && root.right == null) {
            res.add(sum);
        }
        dfsSum(root.left, res, sum);
        dfsSum(root.right, res, sum);

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
        List<Integer> result = dfsSum(root, new ArrayList<>(), 0);

        System.out.println(result.toString());
    }

}
