package org.walmart;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The problem requires designing a stack data structure with not only the standard operations - push, pop, and top -
 * but also the ability to retrieve the minimum element present in the stack at any time, all in constant time O(1).
 */
public class MinStackImpl {

    private static Deque<Integer> stack = new ArrayDeque<>();
    private static Deque<Integer> minStack = new ArrayDeque<>();

    public MinStackImpl() {
        minStack .push(Integer.MAX_VALUE);
    }

    public static void push(int val) {
        if (val != 0) {
            stack.add(val);
        }
        minStack.push(Math.min(val, minStack.pollLast()));
    }

    public static int pop() {
        return stack.removeLast();
    }

    public static int top() {
        return stack.peekLast();
    }

    public static int getMin() {
        return minStack.peekLast();
    }

}
