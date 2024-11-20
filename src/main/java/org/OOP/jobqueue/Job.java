package org.OOP.jobqueue;

public class Job {
        private String name;

        public Job(String name) {
            this.name = name;
        }

        public void execute() {
            System.out.println("Executing job: " + name);
        }
    }

