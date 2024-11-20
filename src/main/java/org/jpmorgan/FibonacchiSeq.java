package org.jpmorgan;

import java.util.Iterator;

public class FibonacchiSeq implements Iterator<Integer> {

    private int current = 0; // The current number in the sequence, initialized to 0.
    private int next = 1;    // The next number in the sequence, initialized to 1.

    // hasNext method is always true since Fibonacci sequence is infinite.
    @Override
    public boolean hasNext() {
        return true; // Fibonacci numbers can be generated indefinitely.
    }

    // The next method returns the current number in the sequence and advances.
    @Override
    public Integer next() {
        int temp = current; // To store the current number to be returned.
        current = next;     // Update current to the next number in sequence.
        next = next + temp; // Calculate the next number in the sequence and update.
        return temp;        // Return the previous value of current.
    }
}
