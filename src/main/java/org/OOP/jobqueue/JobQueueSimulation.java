package org.OOP.jobqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class JobQueueSimulation {
    public static void main(String[] args) {
        int numProcessors = 3;
        LinkedBlockingQueue<Job> jobQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numProcessors);

        // Start job processors
        for (int i = 0; i < numProcessors; i++) {
            executorService.submit(new JobProcessor(jobQueue));
        }

        // Drip-feed jobs
        for (int i = 1; i <= 10; i++) {
            Job job = new Job("Job-" + i);
            jobQueue.offer(job); // Non-blocking call to add job to the queue
            printStatus(jobQueue, executorService);
            sleep(1000); // Simulate time between job submissions
        }

        // Wait for all jobs to be processed
        while (!jobQueue.isEmpty()) {
            printStatus(jobQueue, executorService);
            sleep(1000);
        }

        // Shutdown the executor service when all jobs are processed
        executorService.shutdown();
    }
    private static void printStatus(LinkedBlockingQueue<Job> jobQueue, ExecutorService executorService) {
        System.out.println("Queue size: " + jobQueue.size() +
                ", Active processors: " + ((ThreadPoolExecutor) executorService).getActiveCount());
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
