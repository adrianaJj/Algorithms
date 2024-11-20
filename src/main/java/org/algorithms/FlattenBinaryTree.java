package org.algorithms;

public class FlattenBinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flattenRecursive(root);
    }

    private TreeNode flattenRecursive(TreeNode node) {
        if (node == null) {
            return null;
        }

        // Save the right subtree to reconnect later
        TreeNode rightSubtree = node.right;

        // Flatten the left subtree
        TreeNode leftLastNode = flattenRecursive(node.left);

        // Flatten the right subtree
        TreeNode rightLastNode = flattenRecursive(rightSubtree);

        // If there is a left subtree, move it to the right
        if (leftLastNode != null) {
            node.right = node.left;
            node.left = null;

            // Connect the last node of the left subtree to the start of the right subtree
            leftLastNode.right = rightSubtree;
        }

        // If there is no right subtree, return the last node of the left subtree
        if (rightSubtree == null) {
            return leftLastNode;
        }

        // If there is a right subtree, return the last node of the right subtree
        return rightLastNode;
    }

    // Example usage:
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Create an instance of the class
        FlattenBinaryTree flattener = new FlattenBinaryTree();

        // Flatten the binary tree to a linked list
        flattener.flatten(root);

        // Print the linked list
        TreeNode current = root;
        while (current != null) {
            System.out.println(current.value + " -> ");
            current = current.right;
        }
    }
}

