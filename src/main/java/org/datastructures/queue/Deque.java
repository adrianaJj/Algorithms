package org.datastructures.queue;

import java.util.ArrayDeque;
import java.util.List;

public class Deque {
    public static ArrayDeque<Integer> execute(List<String> program) {
        // initialize a new Arraydeque representing a queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String instruction : program) {
            if (instruction.equals("peek")) {
                if (queue.isEmpty()) {
                    // print warning message if queue is empty
                    System.out.println("Queue is empty!");
                } else {
                    // print out the first item in queue
                    System.out.println(queue.peek());
                }
            } else if (instruction.equals("pop")) {
                if (queue.isEmpty()) {
                    // print warning message if queue is empty
                    System.out.println("Queue is empty!");
                } else {
                    // pop the first item in queue
                    queue.poll();
                }
            } else {
                // get the data in the "push" instruction
                int data = Integer.parseInt(instruction.substring(5));
                // push data to the end of queue
                queue.add(data);
            }
        }
        return queue;
    }
}
