package org.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStackImpl {


    class Node {
        public int val;
        public Node prev, next;

        // Default constructor for Node
        public Node() {
        }

        // Constructor with value for Node
        public Node(int val) {
            this.val = val;
        }
    }

    class DoubleLinkedList {
        private final Node head = new Node(); // Dummy head
        private final Node tail = new Node(); // Dummy tail

        // Constructor to initialize the doubly linked list
        public DoubleLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        // Method to append a node with the given value to the end of the list
        public Node append(int val) {
            Node newNode = new Node(val);
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            return newNode;
        }

        // Static method to remove a given node from the list
        public static Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        // Method to pop the last node from the list
        public Node pop() {
            return remove(tail.prev);
        }

        // Method to peek at the last element's value without removing it
        public int peek() {
            return tail.prev.val;
        }
    }

    class MaxStack {
        private DoubleLinkedList stack = new DoubleLinkedList(); // Stack implemented as a doubly linked list
        private TreeMap<Integer, List<Node>> map = new TreeMap<>(); // TreeMap to maintain max element and its occurrences

        // Constructor for MaxStack
        public MaxStack() {
        }

        // Method to push a value onto the stack
        public void push(int x) {
            Node node = stack.append(x); // Append new value to the stack
            // Add the node reference to the TreeMap using its value as the key
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
        }

        // Method to pop the top value off the stack
        public int pop() {
            Node node = stack.pop(); // Pop node from stack
            List<Node> nodes = map.get(node.val);
            // Remove the node reference from the list in TreeMap
            // If the last occurrence, remove the entry from TreeMap
            nodes.remove(nodes.size() - 1);
            if (nodes.isEmpty()) {
                map.remove(node.val);
            }
            return node.val;
        }

        // Method to retrieve the top value of the stack
        public int top() {
            return stack.peek();
        }

        // Method to get the maximum value from the stack
        public int peekMax() {
            return map.lastKey(); // The last key of TreeMap is the max value
        }

        // Method to remove and return the maximum value from the stack
        public int popMax() {
            int maxValue = peekMax(); // Get the current max value
            List<Node> nodes = map.get(maxValue); // Get the list of nodes having the max value
            Node node = nodes.remove(nodes.size() - 1); // Remove the last occurrence
            if (nodes.isEmpty()) {
                map.remove(maxValue); // Remove the entry from TreeMap if no more occurrences
            }
            DoubleLinkedList.remove(node); // Remove the node from the list
            return maxValue;
        }
    }

/**
 * Usage of the MaxStack class would look like the following:
 * MaxStack maxStack = new MaxStack();
 * maxStack.push(x);
 * int param2 = maxStack.pop();
 * int param3 = maxStack.top();
 * int param4 = maxStack.peekMax();
 * int param5 = maxStack.popMax();
 */
}
