package org.OOP.jobqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class JobProcessor  implements Runnable {
    private LinkedBlockingQueue<Job> jobQueue;

    public JobProcessor(LinkedBlockingQueue<Job> jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Job job = jobQueue.take(); // Blocking call until a job is available
                job.execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
