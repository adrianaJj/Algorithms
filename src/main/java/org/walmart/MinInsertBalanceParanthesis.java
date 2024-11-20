package org.walmart;


import java.util.Stack;

/**
 * Iterate through the string characters.
 * <p>
 * Use a stack to track opening parentheses '(' encountered.
 * <p>
 * For every closing parenthesis ')', check if it pairs with the next character; if so, skip the next character.
 * <p>
 * If there's no matching closing parenthesis or open parenthesis left in the stack, increment the count.
 * <p>
 * Finally, count the remaining open parentheses in the stack and adjust the count accordingly.
 */
public class MinInsertBalanceParanthesis {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    count++;
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }

        count += 2 * stack.size();
        return count;
    }
}
